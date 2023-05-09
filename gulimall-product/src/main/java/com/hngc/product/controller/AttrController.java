package com.hngc.product.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.hngc.product.service.AttrService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "商品属性")
@RestController
@RequestMapping("/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    /**
     * 分页获取分类规格参数
     * 请求参数：
     * {
     * page: 1,//当前页码
     * limit: 10,//每页记录数
     * sidx: 'id',//排序字段
     * order: 'asc/desc',//排序方式
     * key: '华为'//检索关键字
     * }
     *
     * @param pageParams
     * @param catelogId
     * @return
     */
    @PostMapping("page/{catelogId}")
    public Result list(@RequestBody PageParams pageParams, @PathVariable Long catelogId) {
        return Result.success().put("page", attrService.queryPage(pageParams, catelogId));
    }

}
