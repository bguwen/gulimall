package com.hngc.product.controller;

import com.common.utils.PageParams;
import com.common.utils.Result;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.product.entity.AttrGroup;
import com.hngc.product.service.AttrGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

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
     * @param attrGroupId
     * @return
     */
    @PostMapping("list/{attrGroupId}")
    public Result list(@RequestBody PageParams pageParams, @PathVariable Long attrGroupId) {
        return Result.success().put("page", attrGroupService.queryPage(pageParams, attrGroupId));
    }

    /**
     * 根据分组id获取属性分组详情
     *
     * @param attrGroupId
     * @return
     */
    @GetMapping("info/{attrGroupId}")
    public Result getInfo(@PathVariable Long attrGroupId) {
        return Result.success().put("attrGroup", attrGroupService.getInfo(attrGroupId));
    }

    /**
     * 修改属性分组
     *
     * @param attrGroup
     * @return
     */
    @PostMapping("update")
    public Result update(@Validated({UpdateGroup.class}) @RequestBody AttrGroup attrGroup) {
        attrGroupService.updateById(attrGroup);
        return Result.success();
    }

    /**
     * 新增属性分组
     *
     * @param attrGroup
     * @return
     */
    @PostMapping("add")
    public Result add(@Validated({AddGroup.class}) @RequestBody AttrGroup attrGroup) {
        attrGroupService.save(attrGroup);
        return Result.success();
    }

    /**
     * 根据分组id批量删除属性分组
     *
     * @param attrGroupIds
     * @return
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> attrGroupIds) {
        return attrGroupService.removeBatchByIds(attrGroupIds) ? Result.success() : Result.error();
    }

    /**
     * 根据属性分组id 获取属性分组的关联的所有属性
     *
     * @param attrGroupId
     * @return
     */
    @GetMapping("{attrGroupId}/attr/relation")
    public Result attrRelation(@PathVariable String attrGroupId) {
        return Result.success().put("data", attrGroupService.getAttrList(attrGroupId));
    }

    /**
     * 根据属性分组id 获取属性分组里面还没有关联的本分类里面的其他基本属性，方便添加新的关联
     *
     * @param attrGroupId
     * @return
     */
    @PostMapping("{attrGroupId}/noAttr/relation")
    public Result attrNoRelation(@RequestBody PageParams pageParams, @PathVariable String attrGroupId) {
        return Result.success().put("page", attrGroupService.getNoRelation(attrGroupId, pageParams));
    }

    /**
     * 根据分类id获取分类下所有分组
     *
     * @param categoryId
     * @return
     */
    @GetMapping("{categoryId}/withAttr")
    public Result withAttr(@NotNull @PathVariable Long categoryId) {
        return Result.success(attrGroupService.attrGroupWithAttrsByCategoryId(categoryId, false));
    }
}
