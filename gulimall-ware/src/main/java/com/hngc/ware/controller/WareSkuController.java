package com.hngc.ware.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.ware.entity.WareInfo;
import com.hngc.ware.entity.WareSku;
import com.hngc.ware.service.WareSkuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品库存 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "商品库存")
@RestController
@RequestMapping("/wareSku")
public class WareSkuController {

    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 分页查询商品库存
     *
     * @param pageParams
     * @return
     */
    @PostMapping("page")
    private Result page(@RequestBody PageParams pageParams,
                        @RequestParam(required = false) Long skuId, @RequestParam(required = false) Long wareId) {
        return Result.success().put("page", wareSkuService.pageInfo(pageParams, skuId, wareId));
    }

    /**
     * 根据id查询商品库存
     *
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    private Result info(@PathVariable Long id) {
        return Result.success().put("wareSku", wareSkuService.getById(id));
    }

    /**
     * 新增商品库存
     *
     * @param wareSku
     * @return
     */
    @PostMapping("save")
    private Result save(@Validated(AddGroup.class) @RequestBody WareSku wareSku) {
        return wareSkuService.syncSave(wareSku) ? Result.success() : Result.error();
    }

    /**
     * 修改商品库存
     *
     * @param wareSku
     * @return
     */
    @PostMapping("update")
    private Result update(@Validated(UpdateGroup.class) @RequestBody WareSku wareSku) {
        return wareSkuService.updateById(wareSku) ? Result.success() : Result.error();
    }
}
