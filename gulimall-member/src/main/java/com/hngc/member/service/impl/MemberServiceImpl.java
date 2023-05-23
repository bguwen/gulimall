package com.hngc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.member.entity.Member;
import com.hngc.member.mapper.MemberMapper;
import com.hngc.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public PageResult<Member> pageMember(PageParams pageParams) {
        LambdaQueryWrapper<Member> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //封装检索关键字条件
        if (StringUtils.hasLength(pageParams.getKey())) {
            lambdaQueryWrapper
                    .like(Member::getId, pageParams.getKey())
                    .like(Member::getUsername, pageParams.getKey())
                    .like(Member::getMobile, pageParams.getKey())
                    .like(Member::getEmail, pageParams.getKey())
                    .like(Member::getHeader, pageParams.getKey())
                    .like(Member::getGender, pageParams.getKey())
                    .like(Member::getBirth, pageParams.getKey())
                    .like(Member::getCity, pageParams.getKey())
                    .like(Member::getJob, pageParams.getKey())
                    .like(Member::getSign, pageParams.getKey())
                    .like(Member::getCreateTime, pageParams.getKey());
        }
        return new PageResult<Member>().page(this, pageParams, lambdaQueryWrapper);
    }
}
