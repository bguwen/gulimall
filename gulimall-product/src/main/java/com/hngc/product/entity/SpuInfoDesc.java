package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * spu信息介绍
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_spu_info_desc")
@ApiModel(value = "SpuInfoDesc对象", description = "spu信息介绍")
public class SpuInfoDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId
    private Long spuId;

    @ApiModelProperty("商品介绍")
    private String decript;
}
