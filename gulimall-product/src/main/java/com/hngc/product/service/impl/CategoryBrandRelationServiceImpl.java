package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.product.entity.CategoryBrandRelation;
import com.hngc.product.mapper.CategoryBrandRelationMapper;
import com.hngc.product.service.BrandService;
import com.hngc.product.service.CategoryBrandRelationService;
import com.hngc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<CategoryBrandRelation> select(Long brandId) {
        List<CategoryBrandRelation> list = this.list(new LambdaQueryWrapper<CategoryBrandRelation>().eq(brandId != null, CategoryBrandRelation::getBrandId, brandId));
        return list.stream().map(item -> {
            item.setCatelogName(categoryService.getById(item.getCatelogId()).getName());
            item.setBrandName(brandService.getById(brandId).getName());
            return item;
        }).collect(Collectors.toList());
    }
}
