package com.hngc.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.ware.entity.WareInfo;
import com.hngc.ware.mapper.WareInfoMapper;
import com.hngc.ware.service.WareInfoService;
import org.springframework.stereotype.Service;

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

}
