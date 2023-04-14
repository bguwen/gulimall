package com.hngc.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
