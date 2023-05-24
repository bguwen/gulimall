package com.hngc.product.controller;

import com.common.utils.Result;
import com.hngc.product.service.SpuInfoService;
import com.hngc.product.vo.SpuSaveVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param spuSaveVo
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody SpuSaveVo spuSaveVo) {
        spuInfoService.syncSaveSpuInfo(spuSaveVo);
        return Result.success();
    }

}
