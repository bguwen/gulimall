package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.exception.MyException;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.product.entity.SpuInfo;
import com.hngc.product.vo.SpuSaveVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * spu信息 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface SpuInfoService extends IService<SpuInfo> {

    /**
     * 新增商品
     * 多表同步操作
     *
     * @param spuSaveVo
     * @return
     */
    @Transactional
    boolean syncSaveSpuInfo(SpuSaveVo spuSaveVo) throws MyException;

    /**
     * 分页获取sku信息
     *
     * @param pageParams
     * @param brandId
     * @param status
     * @param catelogId
     * @return
     */
    PageResult<SpuInfo> pageInfo(PageParams pageParams, Long brandId, Integer status, Long catelogId);
}
