package com.hngc.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.common.utils.PageResult;
import com.hngc.ware.entity.WareSku;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品库存 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface WareSkuService extends IService<WareSku> {

    /**
     * 分页查询商品库存
     *
     * @param pageParams
     * @param skuId
     * @param wareId
     * @return
     */
    PageResult<WareSku> pageInfo(PageParams pageParams, Long skuId, Long wareId);

    /**
     * 新增商品库存
     * @param wareSku
     * @return
     */
    @Transactional
    boolean syncSave(WareSku wareSku);
}
