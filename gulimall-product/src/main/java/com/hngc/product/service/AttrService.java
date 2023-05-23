package com.hngc.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageParams;
import com.hngc.product.entity.Attr;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
     * 分页获取分类 商品属性 规格参数
     *
     * @param pageParams
     * @param catelogId
     * @param attrType
     * @return
     */
    Map<String, Object> queryPage(PageParams pageParams, Long catelogId, Integer attrType);

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
     *
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

    /**
     * 修改属性【规格参数，销售属性】
     *
     * @param attr
     * @return
     */
    @Transactional
    boolean syncUpdate(Attr attr);

    /**
     * 删除属性【规格参数，销售属性】,同步删除属性分组关联的关联关系
     *
     * @param ids
     * @return
     */
    @Transactional
    boolean syncDelete(List<Attr> ids);
}
