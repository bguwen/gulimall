package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    private Long brandId;

    @ApiModelProperty("品牌名")
    @NotBlank(message = "品牌名不能为空")
    private String name;

    @ApiModelProperty("品牌logo地址")
    @NotNull
    @URL(message = "logo地址非法")
    private String logo;

    @ApiModelProperty("介绍")
    private String descript;

    @ApiModelProperty("显示状态[0-不显示；1-显示]")
    private Byte showStatus;

    @ApiModelProperty("检索首字母")
    @NotNull
    @Pattern(regexp = "[a-zA-Z]",message = "必须为字母")
    private String firstLetter;

    @ApiModelProperty("排序")
    @NotNull
    @Min(0)
    private Integer sort;

    @ApiModelProperty("逻辑删除[0-未删除；1-已删除]")
    @TableLogic
    private Integer isDelete;
}
