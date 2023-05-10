package com.hngc.product.controller;

import com.common.utils.Result;
import com.hngc.product.entity.Category;
import com.hngc.product.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "商品三级分类")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询分类数据，树形结构返回
     *
     * @return 分类数据
     */
    @GetMapping("list/tree")
    public Result listTree() {
        List<Category> data = categoryService.listMemuTree();
        return Result.success().put("data", data);
    }

    /**
     * 根据id删除节点
     *
     * @param catIds
     * @return
     */
    @DeleteMapping("delete")
    public Result deleteMenu(@RequestBody List<Long> catIds) {
        categoryService.removeMenuByIds(catIds);
        return Result.success();
    }

    /**
     * 添加节点
     *
     * @param category
     * @return
     */
    @PostMapping("add")
    public Result addMenu(@RequestBody Category category) {
        category.setIsDelete(0);
        return categoryService.save(category) ? Result.success() : Result.error();
    }

    /**
     * 批量修改节点
     *
     * @param category []
     * @return
     */
    @PostMapping("update")
    public Result updateMenu(@RequestBody List<Category> category) {
        return categoryService.updateBatchById(category) ? Result.success() : Result.error();
    }

    /**
     * 根据id查询商品三级分类详细信息
     *
     * @param catId
     * @return
     */
    @GetMapping("info/{catId}")
    public Result info(@PathVariable Long catId) {
        return Result.success().put("data", categoryService.getById(catId));
    }
}
