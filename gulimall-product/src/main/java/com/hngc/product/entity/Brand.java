package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_brand")
@ApiModel(value = "Brand对象", description = "品牌")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    @TableId(value = "brand_id", type = IdType.AUTO)
    @Null(message = "id必须为空", groups = AddGroup.class)
    @NotNull(message = "id不能为空", groups = UpdateGroup.class)
    private Long brandId;

    @ApiModelProperty("品牌名")
    @NotBlank(message = "品牌名不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    @ApiModelProperty("品牌logo地址")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @URL(message = "logo地址非法",groups = {AddGroup.class, UpdateGroup.class})
    private String logo;

    @ApiModelProperty("介绍")
    private String descript;

    @ApiModelProperty("显示状态[0-不显示；1-显示]")
    private Byte showStatus;

    @ApiModelProperty("检索首字母")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Pattern(regexp = "[a-zA-Z]", message = "必须为字母",groups = {AddGroup.class, UpdateGroup.class})
    private String firstLetter;

    @ApiModelProperty("排序")
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Min(value = 0,groups = {AddGroup.class, UpdateGroup.class})
    private Integer sort;

    @ApiModelProperty("逻辑删除[0-未删除；1-已删除]")
    @TableLogic
    @Null(groups = {AddGroup.class, UpdateGroup.class})
    private Integer isDelete;
}
