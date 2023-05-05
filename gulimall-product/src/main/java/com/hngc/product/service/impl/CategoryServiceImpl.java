package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.product.entity.Category;
import com.hngc.product.mapper.CategoryMapper;
import com.hngc.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<Category> listMemuTree() {
        //查询所有
        List<Category> categoryAll = this.list();
        return categoryAll.stream()
                //找出所有一级分类
                .filter(category -> category.getParentCid() == 0)
                //设置一级分类子节点
                .map(category -> {
                    category.setChildren(getChildren(category, categoryAll));
                    return category;
                })
                //排序
                .sorted(Comparator.comparingInt(e -> (e.getSort() == null ? 0 : e.getSort())))
                .collect(Collectors.toList());

    }

    @Override
    public void removeMenuByIds(List<Long> catIds) {
        // TODO 节点删除前校验
        this.removeByIds(catIds);
    }

    /**
     * 查询当前节点子节点
     *
     * @param category 当前结点
     * @param all      所有结点
     * @return
     */
    private List<Category> getChildren(Category category, List<Category> all) {
        return all.stream()
                .filter(item -> Objects.equals(item.getParentCid(), category.getCatId()))
                .map(item -> {
                    item.setChildren(getChildren(item, all));
                    return item;
                }).sorted(Comparator.comparingInt(e -> (e.getSort() == null ? 0 : e.getSort())))
                .collect(Collectors.toList());
    }
}
