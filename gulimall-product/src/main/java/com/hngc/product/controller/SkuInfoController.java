package com.hngc.product.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.hngc.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "sku信息")
@RestController
@RequestMapping("/skuInfo")
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 分页获取sku信息
     *
     * @param pageParams
     * @return
     */
    @PostMapping("page")
    public Result page(@RequestBody PageParams pageParams, @RequestParam(required = false) Long brandId,
                       @RequestParam(required = false) Long catelogId,
                       @RequestParam(required = false) BigDecimal min, @RequestParam(required = false) BigDecimal max) {
        return Result.success().put("page", skuInfoService.pageInfo(pageParams, brandId, catelogId, min, max));
    }
}
