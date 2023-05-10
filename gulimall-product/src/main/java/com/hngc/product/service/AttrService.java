package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.hngc.product.entity.Attr;

import java.util.Map;

/**
 * <p>
 * 商品属性 服务类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
public interface AttrService extends IService<Attr> {

    /**
     * 分页获取分类规格参数
     *
     * @param pageParams
     * @param catelogId
     * @return
     */
    Map<String, Object> queryPage(PageParams pageParams, Long catelogId);
    /**
     * 根据树子节点id递归查询父节点名称
     *
     * @param parentId     父id
     * @param categoryName
     * @return
     */
    void findParentName(Long parentId, Attr categoryName);

    /**
     * 保存属性信息，同步保存分组信息
     * @param attr
     * @return
     */
    boolean syncSave(Attr attr);

    /**
     * 根据id查询属性详情
     *
     * @param attrId
     * @return
     */
    Attr info(Long attrId);
}
