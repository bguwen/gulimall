package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hngc.product.entity.AttrAttrgroupRelation;

import java.util.List;

/**
 * <p>
 * 属性&属性分组关联 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelation> {

    /**
     * 批量删除属性与分组关联关系
     *
     * @param attrgroupRelationList
     * @return
     */
    boolean deleteBatch(List<AttrAttrgroupRelation> attrgroupRelationList);
}
