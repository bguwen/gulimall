package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.product.entity.SkuInfo;
import com.hngc.product.mapper.SkuInfoMapper;
import com.hngc.product.service.SkuInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    @Override
    public PageResult<SkuInfo> pageInfo(PageParams pageParams, Long brandId, Long catelogId, BigDecimal min, BigDecimal max) {
        LambdaQueryWrapper<SkuInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(pageParams.getKey())) {
            lambdaQueryWrapper
                    .like(SkuInfo::getSkuName, pageParams.getKey())
                    .or()
                    .like(SkuInfo::getSkuDesc, pageParams.getKey())
                    .or()
                    .like(SkuInfo::getSkuTitle, pageParams.getKey())
                    .or()
                    .like(SkuInfo::getSkuSubtitle, pageParams.getKey());
        }
        lambdaQueryWrapper
                .eq(null != brandId && brandId != 0, SkuInfo::getBrandId, brandId)
                .eq(null != catelogId && catelogId != 0, SkuInfo::getCatalogId, catelogId)
                .ge(null != min && min.compareTo(new BigDecimal(0)) != 0, SkuInfo::getPrice, min)
                .le(null != max && max.compareTo(new BigDecimal(0)) != 0, SkuInfo::getPrice, max);
        return new PageResult<SkuInfo>().page(this, pageParams, lambdaQueryWrapper);
    }
}
