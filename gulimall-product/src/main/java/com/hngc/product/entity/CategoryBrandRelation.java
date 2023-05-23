package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 品牌分类关联
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_category_brand_relation")
@ApiModel(value = "CategoryBrandRelation对象", description = "品牌分类关联")
public class CategoryBrandRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("分类id")
    private Long catelogId;

    @TableField(exist = false)
    private String brandName;

    @TableField(exist = false)
    private String catelogName;

    @ApiModelProperty("逻辑删除，0 - 未删除；-1 - 已删除")
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;
}
