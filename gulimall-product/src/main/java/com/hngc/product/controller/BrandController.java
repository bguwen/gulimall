package com.hngc.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.utils.Result;
import com.hngc.product.entity.Brand;
import com.hngc.product.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "品牌")
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     *
     * @return
     */
    @GetMapping("list")
    public Result list() {
        return Result.success().put("data", brandService.list(new LambdaQueryWrapper<Brand>().orderByAsc(Brand::getSort)));
    }

    /**
     * 根据id修改品牌
     *
     * @param brand
     * @return
     */
    @PostMapping("update")
    public Result updateBrand(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return Result.success();
    }

    /**
     * 根据id批量删除品牌
     *
     * @param ids
     * @return
     */
    @DeleteMapping("delete")
    public Result deleteBrand(@RequestBody List<Long> ids) {
        brandService.removeByIds(ids);
        return Result.success();
    }
    /**
     * 添加品牌
     *
     * @param brand
     * @return
     */
    @PostMapping("add")
    public Result addBrand(@Validated @RequestBody Brand brand) {
        brandService.save(brand);
        return Result.success();
    }

}
