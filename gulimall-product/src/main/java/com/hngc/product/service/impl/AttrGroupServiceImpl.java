package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.hngc.product.entity.Attr;
import com.hngc.product.entity.AttrAttrgroupRelation;
import com.hngc.product.entity.AttrGroup;
import com.hngc.product.mapper.AttrGroupMapper;
import com.hngc.product.mapper.AttrMapper;
import com.hngc.product.service.AttrAttrgroupRelationService;
import com.hngc.product.service.AttrGroupService;
import com.hngc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;
    @Autowired
    private AttrMapper attrMapper;

    @Override
    public Map<String, Object> queryPage(PageParams pageParams, Long catId) {
        Page<AttrGroup> page = new Page<>(pageParams.getPage(), pageParams.getLimit());
        /*
         * 构造排序信息
         */
        OrderItem orderItem = new OrderItem();
        orderItem.setColumn(pageParams.getSidx());
        if ("desc".equalsIgnoreCase(pageParams.getOrder())) {
            orderItem.setAsc(false);
        }
        page.setOrders(Collections.singletonList(orderItem));
        /*
         * 构造查询条件
         */
        LambdaQueryWrapper<AttrGroup> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (catId != 0) {
            //检索关键字
            lambdaQueryWrapper.eq(AttrGroup::getCatelogId, catId);
        }
        lambdaQueryWrapper
                .orderByAsc(AttrGroup::getSort)
                .like(StringUtils.hasLength(pageParams.getKey()), AttrGroup::getAttrGroupName, pageParams.getKey())
                .or()
                .like(StringUtils.hasLength(pageParams.getKey()), AttrGroup::getAttrGroupId, pageParams.getKey());
        Page<AttrGroup> pageResult = this.page(page, lambdaQueryWrapper);
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
        map.put("list", pageResult.getRecords());
        return map;
    }

    @Override
    public AttrGroup getInfo(Long attrGroupId) {
        AttrGroup attrGroup = this.getById(attrGroupId);
        if (attrGroup != null) {
            LinkedList<Long> arrayList = new LinkedList<>();
            attrGroup.setCatelogPath(categoryService.findParentPath(attrGroup.getCatelogId(), arrayList));
        }
        return attrGroup;
    }

    @Override
    public List<Attr> getAttrList(String attrGroupId) {
        return attrAttrgroupRelationService.list(new LambdaQueryWrapper<AttrAttrgroupRelation>()
                        .eq(StringUtils.hasLength(attrGroupId), AttrAttrgroupRelation::getAttrGroupId, attrGroupId)
                        .select(AttrAttrgroupRelation::getAttrId))
                .stream().map(item -> attrMapper.selectById(item.getAttrId())).collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> getNoRelation(String attrGroupId, PageParams pageParams) {
        //获取当前分组所属分类id
        Long catelogId = this.getById(attrGroupId).getCatelogId();
        //获取分类下其它分组id
        List<Long> attrGroupIds = this.list(new LambdaQueryWrapper<AttrGroup>()
                        .eq(AttrGroup::getCatelogId, catelogId)
//                        //不含当前分组
//                        .ne(AttrGroup::getAttrGroupId, attrGroupId)
                        .select(AttrGroup::getAttrGroupId))
                .stream().map(AttrGroup::getAttrGroupId).collect(Collectors.toList());
        //其它分组关联的所有属性id
        List<Long> attrIds = attrAttrgroupRelationService.list(new LambdaQueryWrapper<AttrAttrgroupRelation>()
                        .in(AttrAttrgroupRelation::getAttrGroupId, attrGroupIds))
                .stream().map(AttrAttrgroupRelation::getAttrId).collect(Collectors.toList());
        //从当前分类所有属性中移除这些属性  查询并封装数据
        Page<Attr> page = new Page<>(pageParams.getPage(), pageParams.getLimit());
        LambdaQueryWrapper<Attr> lambdaQueryWrapper = new LambdaQueryWrapper<Attr>()
                .eq(Attr::getCatelogId, catelogId).notIn(Attr::getAttrId, attrIds)
                .orderBy(StringUtils.hasLength(pageParams.getOrder()), "asc".equalsIgnoreCase(pageParams.getOrder()), Attr::getAttrId)
                .like(StringUtils.hasLength(pageParams.getKey()), Attr::getAttrName, pageParams.getKey())
                .or()
                .like(StringUtils.hasLength(pageParams.getKey()), Attr::getAttrId, pageParams.getKey());
        Page<Attr> pageResult = attrMapper.selectPage(page, lambdaQueryWrapper);
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
        map.put("list", pageResult.getRecords());
        return map;
    }

}
