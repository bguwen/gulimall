package com.hngc.coupon.controller;

import com.common.to.SkuReductionTo;
import com.common.utils.Result;
import com.hngc.coupon.service.SkuFullReductionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品满减信息 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "商品满减信息")
@RestController
@RequestMapping("/skuFullReduction")
public class SkuFullReductionController {

    @Autowired
    private SkuFullReductionService skuFullReductionService;

    /**
     * 保存sku的优惠、满减等信息
     *
     * @param skuReductionTo
     * @return
     */
    @PostMapping("saveInfo")
    public Result saveInfo(@RequestBody SkuReductionTo skuReductionTo) {
        return skuFullReductionService.saveFullReduction(skuReductionTo) ? Result.success() : Result.error();
    }

}
