package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hngc.product.entity.CategoryBrandRelation;

/**
 * <p>
 * 品牌分类关联 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelation> {

    /**
     * 新增品牌与分类关联关系
     *
     * @param categoryBrandRelation
     * @return
     */
    boolean saveBrandRelation(CategoryBrandRelation categoryBrandRelation);
}
