package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.exception.MyException;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.common.utils.Result;
import com.hngc.feign.ProductFeignService;
import com.hngc.feign.to.SkuInfoTo;
import com.hngc.ware.entity.WareInfo;
import com.hngc.ware.entity.WareSku;
import com.hngc.ware.mapper.WareSkuMapper;
import com.hngc.ware.service.WareInfoService;
import com.hngc.ware.service.WareSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;


/**
 * <p>
 * 商品库存 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements WareSkuService {
    @Autowired
    private ProductFeignService productFeignService;
    @Autowired
    private WareInfoService wareInfoService;

    @Override
    public PageResult<WareSku> pageInfo(PageParams pageParams, Long skuId, Long wareId) {
        LambdaQueryWrapper<WareSku> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String key = pageParams.getKey();
        if (StringUtils.hasLength(key)) {
            lambdaQueryWrapper
                    .like(WareSku::getSkuName, key);
        }
        lambdaQueryWrapper
                .eq(skuId != null, WareSku::getSkuId, skuId)
                .eq(wareId != null, WareSku::getWareId, wareId);
        return new PageResult<WareSku>().page(this, pageParams, lambdaQueryWrapper);
    }

    @Transactional
    @Override
    public boolean syncSave(WareSku wareSku) {
        WareInfo wareInfo = wareInfoService.getById(wareSku.getWareId());
        if (wareInfo == null) {
            throw new MyException("非法请求，不存在仓库信息！");
        }
        Long skuId = wareSku.getSkuId();
        if (skuId == null) {
            throw new MyException("非法请求，不存在skuId！");
        }
        Result result = productFeignService.getSkuInfo(skuId);
        if (result == null || result.get("skuInfo") == null) {
            throw new MyException("非法请求，不存在sku");
        }
        Map<String, String> skuInfoTo = (Map<String, String>) result.get("skuInfo");
        wareSku.setSkuName(skuInfoTo.get("skuName"));
        return this.save(wareSku);
    }
}
