package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.hngc.product.entity.Attr;
import com.hngc.product.entity.AttrGroup;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性分组 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface AttrGroupService extends IService<AttrGroup> {

    /**
     * 分页查询分类属性分组
     *
     * @param pageParams  分页条件
     * @param attrGroupId 三级分类id
     * @return
     */
    Map<String, Object> queryPage(PageParams pageParams, Long attrGroupId);

    /**
     * 根据分组id获取属性分组详情
     *
     * @param attrGroupId
     * @return
     */
    AttrGroup getInfo(Long attrGroupId);

    /**
     * 根据属性分组id 获取属性分组的关联的所有属性
     *
     * @param attrGroupId
     * @return
     */
    List<Attr> getAttrList(String attrGroupId);

    /**
     * 根据属性分组id 获取属性分组里面还没有关联的本分类里面的其他基本属性，方便添加新的关联
     *
     * @param attrGroupId
     * @param pageParams
     * @return
     */
    Map<String, Object> getNoRelation(String attrGroupId, PageParams pageParams);
}
