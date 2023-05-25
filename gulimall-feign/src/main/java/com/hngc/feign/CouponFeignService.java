package com.hngc.feign;

import com.common.to.SkuReductionTo;
import com.common.to.SpuBoundTo;
import com.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {


    /**
     * 保存spu积分信息
     *
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/spuBounds/save")
    Result saveBounds(@RequestBody SpuBoundTo spuBoundTo);

    /**
     * 保存sku的优惠、满减等信息
     *
     * @param skuReductionTo
     * @return
     */
    @PostMapping("/skuFullReduction/saveInfo")
    Result saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);


    @GetMapping("/coupon/member/list")
    Result memberCoupons();
}
