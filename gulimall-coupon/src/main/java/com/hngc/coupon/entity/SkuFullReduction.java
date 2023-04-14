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
 * 商品满减信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_sku_full_reduction")
@ApiModel(value = "SkuFullReduction对象", description = "商品满减信息")
public class SkuFullReduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("spu_id")
    private Long skuId;

    @ApiModelProperty("满多少")
    private BigDecimal fullPrice;

    @ApiModelProperty("减多少")
    private BigDecimal reducePrice;

    @ApiModelProperty("是否参与其他优惠")
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

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Boolean getAddOther() {
        return addOther;
    }

    public void setAddOther(Boolean addOther) {
        this.addOther = addOther;
    }

    @Override
    public String toString() {
        return "SkuFullReduction{" +
        "id = " + id +
        ", skuId = " + skuId +
        ", fullPrice = " + fullPrice +
        ", reducePrice = " + reducePrice +
        ", addOther = " + addOther +
        "}";
    }
}
