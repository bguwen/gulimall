package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.product.entity.CategoryBrandRelation;
import com.hngc.product.mapper.CategoryBrandRelationMapper;
import com.hngc.product.service.BrandService;
import com.hngc.product.service.CategoryBrandRelationService;
import com.hngc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌分类关联 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper, CategoryBrandRelation> implements CategoryBrandRelationService {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;
    @Override
    public boolean saveBrandRelation(CategoryBrandRelation categoryBrandRelation) {
        //查询设置品牌名
        categoryBrandRelation.setBrandName(brandService.getById(categoryBrandRelation.getBrandId()).getName());
        //查询设置分类名称
        categoryBrandRelation.setCatelogName(categoryService.getById(categoryBrandRelation.getCatelogId()).getName());

        return this.save(categoryBrandRelation);
    }
}
