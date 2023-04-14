package com.hngc.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.member.entity.Member;
import com.hngc.member.mapper.MemberMapper;
import com.hngc.member.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
