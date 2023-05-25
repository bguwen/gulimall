package com.hngc.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.constant.ProductConstant;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.common.utils.Result;
import com.hngc.product.entity.SpuInfo;
import com.hngc.product.service.SpuInfoService;
import com.hngc.product.vo.SpuSaveVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * spu信息 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "spu信息")
@RestController
@RequestMapping("/spuInfo")
public class SpuInfoController {

    @Autowired
    private SpuInfoService spuInfoService;

    /**
     * 新增商品
     * 多表同步操作
     *
     * @param spuSaveVo
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody SpuSaveVo spuSaveVo) {
        spuInfoService.syncSaveSpuInfo(spuSaveVo);
        return Result.success();
    }

    /**
     * 分页获取sku信息
     *
     * @param pageParams
     * @return
     */
    @PostMapping("page")
    public Result page(@RequestBody PageParams pageParams, @RequestParam(required = false) Long brandId,
                       @RequestParam(required = false) Integer status, @RequestParam(required = false) Long catelogId) {
        return Result.success().put("page", spuInfoService.pageInfo(pageParams, brandId, status, catelogId));
    }
}
