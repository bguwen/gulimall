package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.ware.entity.Purchase;
import com.hngc.ware.mapper.PurchaseMapper;
import com.hngc.ware.service.PurchaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

}
