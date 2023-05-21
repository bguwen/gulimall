package com.hngc.product.controller;

import com.common.utils.Result;
import com.hngc.product.entity.AttrAttrgroupRelation;
import com.hngc.product.service.AttrAttrgroupRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性&属性分组关联 前端控制器
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Api(tags = "属性&属性分组关联")
@RestController
@RequestMapping("/attrAttrgroupRelation")
public class AttrAttrgroupRelationController {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 添加属性与分组关联关系
     *
     * @param attrAttrgroupRelation
     * @return
     */
    @PostMapping("save")
    public Result save(@Validated @RequestBody AttrAttrgroupRelation attrAttrgroupRelation) {
        return attrAttrgroupRelationService.save(attrAttrgroupRelation) ? Result.success() : Result.error();
    }

    /**
     * 批量删除属性与分组关联关系
     *
     * @param attrgroupRelationList
     * @return
     */
    @DeleteMapping("delete")
    public Result delete(@Validated @RequestBody List<AttrAttrgroupRelation> attrgroupRelationList) {
        return attrAttrgroupRelationService.deleteBatch(attrgroupRelationList) ? Result.success() : Result.error();
    }
}
