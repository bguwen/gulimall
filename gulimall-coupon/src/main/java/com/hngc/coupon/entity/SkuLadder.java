package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private Boolean addOther;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getFullCount() {
        return fullCount;
    }

    public void setFullCount(Integer fullCount) {
        this.fullCount = fullCount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAddOther() {
        return addOther;
    }

    public void setAddOther(Boolean addOther) {
        this.addOther = addOther;
    }

    @Override
    public String toString() {
        return "SkuLadder{" +
        "id = " + id +
        ", skuId = " + skuId +
        ", fullCount = " + fullCount +
        ", discount = " + discount +
        ", price = " + price +
        ", addOther = " + addOther +
        "}";
    }
}
