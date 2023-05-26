package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.PurchaseDetail;
import com.hngc.ware.mapper.PurchaseDetailMapper;
import com.hngc.ware.service.PurchaseDetailService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements PurchaseDetailService {

    @Override
    public PageResult<PurchaseDetail> pageInfo(PageParams pageParams, Integer status, Long wareId) {
        LambdaQueryWrapper<PurchaseDetail> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String key = pageParams.getKey();
        if (StringUtils.hasLength(key)) {
            lambdaQueryWrapper
                    .eq(PurchaseDetail::getId, key)
                    .or()
                    .eq(PurchaseDetail::getPurchaseId, key)
                    .or()
                    .eq(PurchaseDetail::getSkuId, key);
        }
        lambdaQueryWrapper
                .eq(status != null, PurchaseDetail::getStatus, status)
                .eq(status != null, PurchaseDetail::getWareId, wareId);
        return new PageResult<PurchaseDetail>().page(this, pageParams, lambdaQueryWrapper);
    }
}
