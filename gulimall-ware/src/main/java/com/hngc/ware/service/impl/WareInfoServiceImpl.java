package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.WareInfo;
import com.hngc.ware.mapper.WareInfoMapper;
import com.hngc.ware.service.WareInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 仓库信息 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper, WareInfo> implements WareInfoService {

    @Override
    public PageResult<WareInfo> pageInfo(PageParams pageParams) {
        LambdaQueryWrapper<WareInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String key = pageParams.getKey();
        if (StringUtils.hasLength(key)) {
            lambdaQueryWrapper
                    .like(WareInfo::getName, key)
                    .or()
                    .like(WareInfo::getAddress, key)
                    .or()
                    .like(WareInfo::getAreacode, key);
        }
        return new PageResult<WareInfo>().page(this, pageParams, lambdaQueryWrapper);
    }
}
