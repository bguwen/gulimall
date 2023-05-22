package com.hngc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.member.entity.MemberLevel;
import com.hngc.member.mapper.MemberLevelMapper;
import com.hngc.member.service.MemberLevelService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员等级 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {

    @Override
    public PageResult<MemberLevel> levelPage(PageParams pageParams) {
        return new PageResult<MemberLevel>().page(this, pageParams,
                new LambdaQueryWrapper<MemberLevel>()
                        .like(StringUtils.hasLength(pageParams.getKey()), MemberLevel::getId, pageParams.getKey())
                        .like(StringUtils.hasLength(pageParams.getKey()), MemberLevel::getName, pageParams.getKey()));

    }
}
