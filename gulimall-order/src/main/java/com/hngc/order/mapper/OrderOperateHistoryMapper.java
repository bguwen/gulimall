package com.hngc.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.order.entity.OrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单操作历史记录 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface OrderOperateHistoryMapper extends BaseMapper<OrderOperateHistory> {

}
