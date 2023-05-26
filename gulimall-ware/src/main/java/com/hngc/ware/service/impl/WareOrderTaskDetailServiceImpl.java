package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.WareOrderTask;
import com.hngc.ware.entity.WareOrderTaskDetail;
import com.hngc.ware.mapper.WareOrderTaskDetailMapper;
import com.hngc.ware.service.WareOrderTaskDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存工作单 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper, WareOrderTaskDetail> implements WareOrderTaskDetailService {

    @Override
    public PageResult<WareOrderTaskDetail> pageInfo(PageParams pageParams, Integer status, Long wareId) {
        LambdaQueryWrapper<WareOrderTaskDetail> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(status != null, WareOrderTaskDetail::getLockStatus, status);
        lambdaQueryWrapper.eq(wareId != null, WareOrderTaskDetail::getWareId, wareId);
        return new PageResult<WareOrderTaskDetail>().page(this, pageParams, lambdaQueryWrapper);
    }
}
