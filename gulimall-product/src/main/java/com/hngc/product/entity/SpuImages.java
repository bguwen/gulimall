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
 * spu图片
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_spu_images")
@ApiModel(value = "SpuImages对象", description = "spu图片")
public class SpuImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("图片名")
    private String imgName;

    @ApiModelProperty("图片地址")
    private String imgUrl;

    @ApiModelProperty("顺序")
    private Integer imgSort;

    @ApiModelProperty("是否默认图")
    private Byte defaultImg;
}
