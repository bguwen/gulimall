package com.hngc.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.PurchaseDetail;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface PurchaseDetailService extends IService<PurchaseDetail> {

    /**
     * 分页查询采购需求
     *
     * @param pageParams
     * @param status
     * @param wareId
     * @return
     */
    PageResult<PurchaseDetail> pageInfo(PageParams pageParams, Integer status, Long wareId);
}
