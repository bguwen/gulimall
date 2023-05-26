package com.hngc.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.WareOrderTask;
import com.hngc.ware.entity.WareOrderTaskDetail;

/**
 * <p>
 * 库存工作单 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetail> {

    /**
     * 查询采购需求
     *
     * @param pageParams
     * @param status
     * @param wareId
     * @return
     */
    PageResult<WareOrderTaskDetail> pageInfo(PageParams pageParams, Integer status, Long wareId);
}
