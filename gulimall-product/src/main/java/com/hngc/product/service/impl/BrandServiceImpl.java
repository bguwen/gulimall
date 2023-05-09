package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.hngc.product.entity.Brand;
import com.hngc.product.mapper.BrandMapper;
import com.hngc.product.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 品牌 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Override
    public Map<String, Object> queryPage(PageParams pageParams) {
        Page<Brand> page = new Page<>(pageParams.getPage(), pageParams.getLimit());
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .orderByAsc(Brand::getSort)
                .like(StringUtils.hasText(pageParams.getKey()), Brand::getName, pageParams.getKey())
                .or()
                .like(StringUtils.hasText(pageParams.getKey()), Brand::getDescript, pageParams.getKey());
        Page<Brand> pageResult = this.page(page, lambdaQueryWrapper);

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
}
