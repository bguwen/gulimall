package com.hngc.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.coupon.entity.CouponSpuRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 优惠券与产品关联 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface CouponSpuRelationMapper extends BaseMapper<CouponSpuRelation> {

}
