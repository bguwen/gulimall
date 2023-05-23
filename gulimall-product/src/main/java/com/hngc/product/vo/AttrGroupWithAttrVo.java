package com.hngc.product.vo;

import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.hngc.product.entity.Attr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;


@Data
@ApiModel(value = "AttrGroupWithAttrVo", description = "AttrGroupWithAttrVo")
public class AttrGroupWithAttrVo {

    @ApiModelProperty("分组id")
    @NotNull(groups = UpdateGroup.class)
    @Null(groups = AddGroup.class)
    private Long attrGroupId;

    @ApiModelProperty("组名")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class})
    private String attrGroupName;

    @ApiModelProperty("排序")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Min(value = 0, groups = {AddGroup.class, UpdateGroup.class})
    @Max(value = 100, groups = {AddGroup.class, UpdateGroup.class})
    private Integer sort;

    @ApiModelProperty("描述")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class})
    private String descript;

    @ApiModelProperty("组图标")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class})
    private String icon;

    @ApiModelProperty("所属分类id")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    private Long catelogId;

    @ApiModelProperty("分组")
    private List<Attr> attrs;
}
