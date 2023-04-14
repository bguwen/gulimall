package com.hngc.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.order.entity.OrderSetting;
import com.hngc.order.mapper.OrderSettingMapper;
import com.hngc.order.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单配置信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {

}
