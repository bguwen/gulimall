package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 属性&属性分组关联
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_attr_attrgroup_relation")
@ApiModel(value = "AttrAttrgroupRelation对象", description = "属性&属性分组关联")
public class AttrAttrgroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("属性id")
    private Long attrId;

    @ApiModelProperty("属性分组id")
    private Long attrGroupId;

    @ApiModelProperty("属性组内排序")
    private Integer attrSort;

    public AttrAttrgroupRelation() {
    }

    public AttrAttrgroupRelation(Long attrId, Long attrGroupId) {
        this.attrId = attrId;
        this.attrGroupId = attrGroupId;
    }
}
