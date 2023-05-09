package com.hngc.product.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
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
     * 分页查询品牌
     *
     * @return
     */
    @PostMapping("page")
    public Result page(@RequestBody PageParams pageParams) {
        return Result.success().put("page", brandService.queryPage(pageParams));
    }

    /**
     * 根据id修改品牌
     *
     * @param brand
     * @return
     */
    @PostMapping("update")
    public Result updateBrand(@Validated(UpdateGroup.class) @RequestBody Brand brand) {
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
    public Result addBrand(@Validated(AddGroup.class) @RequestBody Brand brand) {
        brandService.save(brand);
        return Result.success();
    }

    /**
     * 根据分组id获取属性分组详情
     *
     * @param brandId
     * @return
     */
    @GetMapping("info/{brandId}")
    public Result getInfo(@PathVariable Long brandId) {
        return Result.success().put("brand", brandService.getById(brandId));
    }

    /**
     * 根据id修改状态
     *
     * @param brand
     * @return
     */
    @PatchMapping("update/status")
    public Result updateStatus( @RequestBody Brand brand) {
        return brandService.updateById(brand) ? Result.success() : Result.error();
    }
}
