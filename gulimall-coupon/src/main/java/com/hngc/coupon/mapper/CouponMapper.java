package com.hngc.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.coupon.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 优惠券信息 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface CouponMapper extends BaseMapper<Coupon> {

}
