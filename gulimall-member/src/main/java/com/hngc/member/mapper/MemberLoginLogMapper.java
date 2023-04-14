package com.hngc.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.member.entity.MemberLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员登录记录 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface MemberLoginLogMapper extends BaseMapper<MemberLoginLog> {

}
