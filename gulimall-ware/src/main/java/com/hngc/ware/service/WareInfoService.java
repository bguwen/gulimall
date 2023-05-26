package com.hngc.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.WareInfo;

/**
 * <p>
 * 仓库信息 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface WareInfoService extends IService<WareInfo> {

    /**
     * 分页查询仓库信息
     *
     * @param pageParams
     * @return
     */
    PageResult<WareInfo> pageInfo(PageParams pageParams);
}
