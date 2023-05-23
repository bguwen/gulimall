package com.hngc.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.member.entity.Member;

/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface MemberService extends IService<Member> {

    /**
     * 分页获取会员信息
     *
     * @param pageParams
     * @return
     */
    PageResult<Member> pageMember(PageParams pageParams);
}
