package com.hngc.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * spu信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Getter
@Setter
@TableName("pms_spu_info")
@ApiModel(value = "SpuInfo对象", description = "spu信息")
public class SpuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品名称")
    private String spuName;

    @ApiModelProperty("商品描述")
    private String spuDescription;

    @ApiModelProperty("所属分类id")
    private Long catelogId;

    @ApiModelProperty("品牌id")
    private Long brandId;

    private BigDecimal weight;

    @ApiModelProperty("上架状态[0 - 下架，1 - 上架]")
    private Byte publishStatus;
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
