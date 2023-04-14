package com.hngc.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.member.entity.MemberLoginLog;
import com.hngc.member.mapper.MemberLoginLogMapper;
import com.hngc.member.service.MemberLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员登录记录 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog> implements MemberLoginLogService {

}
