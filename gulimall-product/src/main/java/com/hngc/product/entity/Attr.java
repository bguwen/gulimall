package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_attr")
@ApiModel(value = "Attr对象", description = "商品属性")
public class Attr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("属性id")
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Long attrId;

    @ApiModelProperty("分组id")
    @TableField(exist = false)
    private Long attrGroupId;

    @ApiModelProperty("完整分类路径id  如:   [2,34,225]")
    @TableField(exist = false)
    private List<Long> catelogPath;

    @ApiModelProperty("属性名")
    private String attrName;

    @ApiModelProperty("是否需要检索[0-不需要，1-需要]")
    private Byte searchType;

    @ApiModelProperty("属性图标")
    private String icon;

    @ApiModelProperty("可选值列表[用逗号分隔]")
    private String valueSelect;

    @ApiModelProperty("属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer attrType;

    @ApiModelProperty("启用状态[0 - 禁用，1 - 启用]")
    private Long enable;

    @ApiModelProperty("所属分类")
    private Long catelogId;

    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Byte showDesc;

    @ApiModelProperty("完整分类路径名称 如: “手机/手机通讯/手机”")
    @TableField(exist = false)
    private String catelogName;
    @ApiModelProperty("分组名称 如: “主体”")
    @TableField(exist = false)
    private String groupName = "";
    @ApiModelProperty("逻辑删除[0-未删除；1-已删除]")
    @TableLogic
    private Integer isDelete;
}
