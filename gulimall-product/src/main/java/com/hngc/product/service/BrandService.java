package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.hngc.product.entity.Brand;

import java.util.Map;

/**
 * <p>
 * 品牌 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface BrandService extends IService<Brand> {

    /**
     * 分页查询品牌
     *
     * @param pageParams
     * @return
     */
    Map<String, Object> queryPage(PageParams pageParams);

}
