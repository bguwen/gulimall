package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.hngc.product.entity.AttrGroup;
import com.hngc.product.entity.Category;
import com.hngc.product.mapper.AttrGroupMapper;
import com.hngc.product.service.AttrGroupService;
import com.hngc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

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
            lambdaQueryWrapper
                    .eq(AttrGroup::getCatelogId, catId)
                    .like(StringUtils.hasLength(pageParams.getKey()), AttrGroup::getAttrGroupName, pageParams.getKey())
                    .or()
                    .like(StringUtils.hasLength(pageParams.getKey()), AttrGroup::getAttrGroupId, pageParams.getKey())
            ;
        }

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
            Category threeCategory = categoryService.getById(attrGroup.getCatelogId());
            if (threeCategory != null) {
                Category twoCategory = categoryService.getById(threeCategory.getParentCid());
                attrGroup.setCatelogPath(Arrays.asList(twoCategory.getParentCid(), twoCategory.getCatId(), attrGroup.getCatelogId()));
            }
        }
        return attrGroup;
    }

}
