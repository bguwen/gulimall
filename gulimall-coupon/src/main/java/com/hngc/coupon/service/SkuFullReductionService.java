package com.hngc.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.to.SkuReductionTo;
import com.hngc.coupon.entity.SkuFullReduction;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品满减信息 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface SkuFullReductionService extends IService<SkuFullReduction> {

    /**
     * 保存sku的优惠、满减等信息
     *
     * @param skuReductionTo
     * @return
     */
    @Transactional
    boolean saveFullReduction(SkuReductionTo skuReductionTo);
}
