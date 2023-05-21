package com.hngc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.product.entity.AttrAttrgroupRelation;
import com.hngc.product.mapper.AttrAttrgroupRelationMapper;
import com.hngc.product.service.AttrAttrgroupRelationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性&属性分组关联 服务实现类
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper, AttrAttrgroupRelation> implements AttrAttrgroupRelationService {

    @Override
    public boolean deleteBatch(List<AttrAttrgroupRelation> attrgroupRelationList) {
        attrgroupRelationList.forEach(attrAttrgroupRelation -> {
            this.remove(new LambdaQueryWrapper<AttrAttrgroupRelation>()
                    .eq(AttrAttrgroupRelation::getAttrId, attrAttrgroupRelation.getAttrId())
                    .eq(AttrAttrgroupRelation::getAttrGroupId, attrAttrgroupRelation.getAttrGroupId())
            );
        });
        return true;
    }
}
