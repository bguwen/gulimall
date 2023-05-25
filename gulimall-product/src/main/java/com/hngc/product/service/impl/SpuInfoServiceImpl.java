package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.constant.ProductConstant;
import com.common.exception.MyException;
import com.common.to.SkuReductionTo;
import com.common.to.SpuBoundTo;
import com.common.utils.HttpStatus;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.common.utils.Result;
import com.hngc.feign.CouponFeignService;
import com.hngc.product.entity.*;
import com.hngc.product.mapper.SpuInfoMapper;
import com.hngc.product.service.*;
import com.hngc.product.vo.SpuSaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * spu信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements SpuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;
    @Autowired
    private SpuImagesService spuImagesService;
    @Autowired
    private ProductAttrValueService productAttrValueService;
    @Autowired
    private SkuInfoService skuInfoService;
    @Autowired
    private SkuImagesService skuImagesService;
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;
    @Autowired
    private CouponFeignService couponFeignService;

    /**
     * 新增商品
     * 多表同步操作
     * TODO 分布式事务待完善
     *
     * @param spuSaveVo
     * @return
     */
    @Transactional
    @Override
    public boolean syncSaveSpuInfo(SpuSaveVo spuSaveVo) throws MyException {
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(spuSaveVo, spuInfo);
        //上架状态
        spuInfo.setPublishStatus(ProductConstant.SPU_NO_PUBLISH.getCode());
        //保存spu基本信息 pms_spu_info
        this.save(spuInfo);
        Long spuId = spuInfo.getId();
        //保存spu描述图片 pms_spu_info_desc
        SpuInfoDesc spuInfoDesc = new SpuInfoDesc();
        spuInfoDesc.setSpuId(spuId);
        spuInfoDesc.setDecript(String.join(",", spuSaveVo.getDecript()));
        spuInfoDescService.save(spuInfoDesc);

        //保存spu图片集 pms_spu_images
        List<String> images = spuSaveVo.getImages();
        if (images != null && images.size() > 0) {
            List<SpuImages> imagesList = images.stream().map(item -> {
                SpuImages spuImages = new SpuImages();
                spuImages.setSpuId(spuId);
                spuImages.setImgUrl(item);
                return spuImages;
            }).collect(Collectors.toList());
            spuImagesService.saveBatch(imagesList);
        }
        //保存spu规格参数 pms_product_attr_value
        List<ProductAttrValue> productAttrValueList = spuSaveVo.getBaseAttrs().stream().map(item -> {
            ProductAttrValue productAttrValue = new ProductAttrValue();
            productAttrValue.setSpuId(spuId);
            productAttrValue.setAttrId(item.getAttrId());
//      TODO      productAttrValue.setAttrName();
            productAttrValue.setQuickShow(item.getShowDesc());
//      TODO      productAttrValue.setAttrSort();
            return productAttrValue;
        }).collect(Collectors.toList());
        productAttrValueService.saveBatch(productAttrValueList);
        //保存spu积分信息 pms_sms -> sms_spu_bounds
        SpuSaveVo.BoundsDTO bounds = spuSaveVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuId);

        Result result = couponFeignService.saveBounds(spuBoundTo);
        if (result == null || !Objects.equals(result.get(Result.CODE_TAG), HttpStatus.SUCCESS)) {
            throw new MyException("保存spu积分信息失败", HttpStatus.ERROR);
        }

        //保存当前spu对应的所有sku信息
        List<SpuSaveVo.SkusDTO> skus = spuSaveVo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                SkuInfo skuInfo = new SkuInfo();
                BeanUtils.copyProperties(item, skuInfo);
                skuInfo.setBrandId(spuInfo.getBrandId());
                skuInfo.setCatalogId(spuInfo.getCatelogId());
                skuInfo.setSaleCount(0L);
                skuInfo.setSpuId(spuId);
                item.getImages().forEach(item2 -> {
                    if (item2.getDefaultImg() == 1) {
                        skuInfo.setSkuDefaultImg(item2.getImgUrl());
                    }
                });
                //sku的基本信息：pms_sku_info
                skuInfoService.save(skuInfo);
                Long skuId = skuInfo.getSkuId();
                List<SkuImages> skuImagesList = item.getImages().stream().map(item3 -> {
                    SkuImages skuImages = new SkuImages();
                    skuImages.setSkuId(skuId);
                    skuImages.setImgUrl(item3.getImgUrl());
                    skuImages.setDefaultImg(item3.getDefaultImg());
                    return skuImages;
                }).filter(i -> StringUtils.hasLength(i.getImgUrl())).collect(Collectors.toList());
                //sku的图片信息：pms_sku_images
                skuImagesService.saveBatch(skuImagesList);
                //sku的销售属性信息：pms_sku_sale_attr_value
                List<SkuSaleAttrValue> skuSaleAttrValueList = item.getAttr().stream().map(item4 -> {
                    SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
                    BeanUtils.copyProperties(item4, skuSaleAttrValue);
                    skuSaleAttrValue.setSkuId(skuId);
                    return skuSaleAttrValue;
                }).collect(Collectors.toList());
                skuSaleAttrValueService.saveBatch(skuSaleAttrValueList);
                //保存sku的优惠、满减等信息：gulimall_sms -> sms_sku_ladder sms_sku_full_reduction sms_member_price

                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                skuReductionTo.setMemberPrice(item.getMemberPrice());
                skuReductionTo.setSkuId(skuId);
                if (skuReductionTo.getFullCount() > 0 && skuReductionTo.getFullPrice().compareTo(new BigDecimal(0)) > 0) {
                    Result result1 = couponFeignService.saveSkuReduction(skuReductionTo);
                    if (result1 == null || !Objects.equals(result1.get(Result.CODE_TAG), HttpStatus.SUCCESS)) {
                        throw new MyException("保存sku的优惠、满减等信息失败", HttpStatus.ERROR);
                    }
                }
            });
        }
        return true;
    }

    @Override
    public PageResult<SpuInfo> pageInfo(PageParams pageParams, Long brandId, Integer status, Long catelogId) {
        LambdaQueryWrapper<SpuInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(pageParams.getKey())) {
            lambdaQueryWrapper
                    .like(SpuInfo::getSpuName, pageParams.getKey())
                    .or()
                    .like(SpuInfo::getSpuDescription, pageParams.getKey())
                    .or()
                    .like(SpuInfo::getId, pageParams.getKey());
        }
        lambdaQueryWrapper
                .eq(null != brandId && brandId != 0, SpuInfo::getBrandId, brandId)
                .eq(null != catelogId && catelogId != 0, SpuInfo::getCatelogId, catelogId)
                .eq(null != status && !ProductConstant.SPU_UNDEFINED_PUBLISH.getCode().equals(status), SpuInfo::getPublishStatus, status);
        return new PageResult<SpuInfo>().page(this, pageParams, lambdaQueryWrapper);
    }

}
