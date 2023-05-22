package com.hngc.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.member.entity.MemberLevel;

/**
 * <p>
 * 会员等级 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface MemberLevelService extends IService<MemberLevel> {

    /**
     * 分页获取会员等级
     *
     * @param pageParams
     * @return
     */
    PageResult<MemberLevel> levelPage(PageParams pageParams);
}
