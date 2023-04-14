package com.hngc.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.coupon.entity.HomeSubject;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface HomeSubjectMapper extends BaseMapper<HomeSubject> {

}
