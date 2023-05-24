package com.hngc.coupon.controller;

import com.common.utils.Result;
import com.hngc.coupon.entity.SpuBounds;
import com.hngc.coupon.service.SpuBoundsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品spu积分设置 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "商品spu积分设置")
@RestController
@RequestMapping("/spuBounds")
public class SpuBoundsController {

    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * 保存spu积分信息
     *
     * @param spuBounds
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody SpuBounds spuBounds) {
        return spuBoundsService.save(spuBounds) ? Result.success() : Result.error();
    }

}
