package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.product.entity.SkuInfo;

import java.math.BigDecimal;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 分页获取sku信息
     *
     * @param pageParams
     * @param brandId
     * @param catelogId
     * @param min
     * @param max
     * @return
     */
    PageResult<SkuInfo> pageInfo(PageParams pageParams, Long brandId, Long catelogId, BigDecimal min, BigDecimal max);
}
