package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.common.valid.UpdateGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 属性分组
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_attr_group")
@ApiModel(value = "AttrGroup对象", description = "属性分组")
public class AttrGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分组id")
    @NotNull(groups = UpdateGroup.class)
    @Null(groups = AttrGroup.class)
    @TableId(value = "attr_group_id", type = IdType.AUTO)
    private Long attrGroupId;

    @ApiModelProperty("组名")
    @NotNull(groups = {AttrGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AttrGroup.class, UpdateGroup.class})
    private String attrGroupName;

    @ApiModelProperty("排序")
    @NotNull(groups = {AttrGroup.class, UpdateGroup.class})
    @Min(value = 0, groups = {AttrGroup.class, UpdateGroup.class})
    @Max(value = 100, groups = {AttrGroup.class, UpdateGroup.class})
    private Integer sort;

    @ApiModelProperty("描述")
    @NotNull(groups = {AttrGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AttrGroup.class, UpdateGroup.class})
    private String descript;

    @ApiModelProperty("组图标")
    @NotNull(groups = {AttrGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AttrGroup.class, UpdateGroup.class})
    private String icon;

    @ApiModelProperty("所属分类id")
    @NotNull(groups = {AttrGroup.class, UpdateGroup.class})
    private Long catelogId;

    @ApiModelProperty("逻辑删除")
    @JsonIgnore
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("完整分类路径")
    @TableField(exist = false)
    private List<Long> catelogPath;
}
