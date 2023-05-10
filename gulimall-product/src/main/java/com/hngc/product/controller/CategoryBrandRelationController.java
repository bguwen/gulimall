package com.hngc.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.utils.Result;
import com.hngc.product.entity.CategoryBrandRelation;
import com.hngc.product.service.CategoryBrandRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 品牌分类关联 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "品牌分类关联")
@RestController
@RequestMapping("/categoryBrandRelation")
public class CategoryBrandRelationController {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 获取当前品牌关联所有分类
     *
     * @param brandId
     * @return
     */
    @GetMapping("catelog/list")
    public Result list(@RequestParam Long brandId) {
        return Result.success(categoryBrandRelationService.list(new LambdaQueryWrapper<CategoryBrandRelation>()
                .eq(brandId != null, CategoryBrandRelation::getBrandId, brandId)));
    }

    /**
     * 新增品牌与分类关联关系
     *
     * @param categoryBrandRelation
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody CategoryBrandRelation categoryBrandRelation) {
        return categoryBrandRelationService.saveBrandRelation(categoryBrandRelation) ? Result.success() : Result.error();
    }

}
