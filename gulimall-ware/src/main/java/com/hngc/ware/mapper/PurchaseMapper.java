package com.hngc.ware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.ware.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 采购信息 Mapper 接口
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Mapper
public interface PurchaseMapper extends BaseMapper<Purchase> {

}
