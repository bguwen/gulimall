package com.hngc.product.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.hngc.product.service.AttrGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "属性分组")
@RestController
@RequestMapping("/attrGroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 分页查询分类属性分组
     * @param pageParams
     * @param attrGroupId
     * @return
     */
    @PostMapping("list/{attrGroupId}")
    public Result list(@RequestBody PageParams pageParams, @PathVariable Long attrGroupId) {
        return Result.success().put("page",attrGroupService.queryPage(pageParams, attrGroupId));
    }

}
