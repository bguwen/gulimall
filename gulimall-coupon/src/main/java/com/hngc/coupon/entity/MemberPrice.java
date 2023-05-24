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
 * 商品会员价格
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Data
@TableName("sms_member_price")
@ApiModel(value = "MemberPrice对象", description = "商品会员价格")
public class MemberPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    private Long skuId;

    @ApiModelProperty("会员等级id")
    private Long memberLevelId;

    @ApiModelProperty("会员等级名")
    private String memberLevelName;

    @ApiModelProperty("会员对应价格")
    private BigDecimal memberPrice;

    @ApiModelProperty("可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;

}
