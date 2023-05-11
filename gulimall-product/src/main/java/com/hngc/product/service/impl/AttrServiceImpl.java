package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.hngc.product.entity.Attr;
import com.hngc.product.entity.AttrAttrgroupRelation;
import com.hngc.product.entity.AttrGroup;
import com.hngc.product.entity.Category;
import com.hngc.product.mapper.AttrMapper;
import com.hngc.product.service.AttrAttrgroupRelationService;
import com.hngc.product.service.AttrGroupService;
import com.hngc.product.service.AttrService;
import com.hngc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Override
    public Map<String, Object> queryPage(PageParams pageParams, Long catelogId) {
        Page<Attr> page = new Page<>(pageParams.getPage(), pageParams.getLimit());

        LambdaQueryWrapper<Attr> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(catelogId != null && catelogId != 0, Attr::getCatelogId, catelogId)
                .like(StringUtils.hasText(pageParams.getKey()), Attr::getAttrName, pageParams.getKey());

        //分页查询所有商品属性
        Page<Attr> pageResult = this.page(page, lambdaQueryWrapper);
        //根据分类id查询分组下所有分组
        List<Attr> list = pageResult.getRecords().stream().map(item -> {
            findParentName(item.getCatelogId(), item);
            /*
              根据商品属性id在中间表查询分组id,再根据分组id查询分组信息
             */
            AttrGroup attrGroup = attrGroupService.getById(
                    attrAttrgroupRelationService.getOne(
                            new LambdaQueryWrapper<AttrAttrgroupRelation>()
                                    .eq(AttrAttrgroupRelation::getAttrId, item.getAttrId())).getAttrGroupId());
            item.setGroupName(attrGroup.getAttrGroupName());
            return item;
        }).collect(Collectors.toList());

        Map<String, Object> map = new HashMap<>();
            /*
              总记录数
             */
        map.put("totalCount", pageResult.getTotal());
            /*
             每页大小
             */
        map.put("pageSize", pageResult.getSize());
            /*
             总页码
             */
        map.put("totalPage", pageResult.getPages());
        /*
         *当前页码
         */
        map.put("currPage", pageResult.getCurrent());
        /*
         *当前页所有数据
         */
        map.put("list", list);
        return map;
    }

    /**
     * 根据树子节点id递归查询父节点名称
     *
     * @param parentId 父id
     * @param attr
     * @return
     */
    public void findParentName(Long parentId, Attr attr) {
        Category category = categoryService.getById(parentId);
        if (attr.getCatelogName() == null) {
            attr.setCatelogName(category.getName());
        } else {
            attr.setCatelogName(attr.getCatelogName() + "/" + category.getName());
        }
        if (category.getParentCid() != 0) {
            findParentName(category.getParentCid(), attr);
        }
    }

    @Override
    @Transactional
    public boolean syncSave(Attr attr) {
        //查询分组信息
        AttrGroup attrGroup = attrGroupService.getById(attr.getAttrGroupId());
        attr.setGroupName(attrGroup.getAttrGroupName());
        //保存属性信息
        this.save(attr);
        //保存属性分组关联表信息
        return attrAttrgroupRelationService.save(new AttrAttrgroupRelation(attr.getAttrId(), attrGroup.getAttrGroupId()));
    }

    @Override
    public Attr info(Long attrId) {
        Attr attr = this.getById(attrId);
        if (attr == null) {
            return null;
        }
        AttrAttrgroupRelation attrAttrgroupRelation = attrAttrgroupRelationService.getOne(new LambdaQueryWrapper<AttrAttrgroupRelation>()
                .eq(attrId != null, AttrAttrgroupRelation::getAttrId, attrId));
        //设置分组id
        attr.setAttrGroupId(attrAttrgroupRelation.getAttrGroupId());
        //设置完整路径
        LinkedList<Long> linkedList = new LinkedList<>();
        categoryService.findParentPath(attr.getCatelogId(), linkedList);
        attr.setCatelogPath(linkedList);
        return attr;
    }

    @Transactional
    @Override
    public boolean syncUpdate(Attr attr) {
        this.updateById(attr);
        AttrAttrgroupRelation attrAttrgroupRelation = new AttrAttrgroupRelation();
        attrAttrgroupRelation.setAttrGroupId(attr.getAttrGroupId());
        attrAttrgroupRelationService.update(attrAttrgroupRelation, new LambdaQueryWrapper<AttrAttrgroupRelation>()
                .eq(AttrAttrgroupRelation::getAttrId, attr.getAttrId()));
        return true;
    }

}
