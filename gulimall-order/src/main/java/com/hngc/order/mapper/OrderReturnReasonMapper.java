package com.hngc.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.order.entity.OrderReturnReason;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 退货原因 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface OrderReturnReasonMapper extends BaseMapper<OrderReturnReason> {

}
