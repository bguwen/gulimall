package com.hngc.feign;

import com.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("gulimall-product")
public interface ProductFeignService {

    /**
     * 根据skuId获取sku信息gulimall-product
     *
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/info/{skuId}")
    Result getSkuInfo(@PathVariable Long skuId);
}
