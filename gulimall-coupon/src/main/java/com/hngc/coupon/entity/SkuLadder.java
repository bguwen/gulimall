package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品阶梯价格
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Data
@TableName("sms_sku_ladder")
@ApiModel(value = "SkuLadder对象", description = "商品阶梯价格")
public class SkuLadder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("spu_id")
    private Long skuId;

    @ApiModelProperty("满几件")
    private Integer fullCount;

    @ApiModelProperty("打几折")
    private BigDecimal discount;

    @ApiModelProperty("折后价")
    private BigDecimal price;

    @ApiModelProperty("是否叠加其他优惠[0-不可叠加，1-可叠加]")
    private Integer addOther;

}
