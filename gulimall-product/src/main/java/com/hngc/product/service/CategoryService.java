package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hngc.product.entity.Category;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询分类数据，树形返回
     *
     * @return
     */
    List<Category> listMemuTree();

    /**
     * 根据id批量删除节点
     * @param catIds
     */
    void removeMenuByIds(List<Long> catIds);
}
