package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hngc.product.entity.CategoryBrandRelation;
import com.hngc.product.vo.BrandVo;

import java.util.List;

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
     * 获取当前品牌关联所有分类
     *
     * @param brandId
     * @return
     */
    List<CategoryBrandRelation> select(Long brandId);

    /**
     * 根据分类id获取分类关联的品牌
     *
     * @param categoryId
     * @return
     */
    List<BrandVo> getBrandsList(Long categoryId);
}
