package com.hngc.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.product.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
