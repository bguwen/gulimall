package com.hngc.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单项信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("oms_order_item")
@ApiModel(value = "OrderItem对象", description = "订单项信息")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("order_id")
    private Long orderId;

    @ApiModelProperty("order_sn")
    private String orderSn;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("spu_name")
    private String spuName;

    @ApiModelProperty("spu_pic")
    private String spuPic;

    @ApiModelProperty("品牌")
    private String spuBrand;

    @ApiModelProperty("商品分类id")
    private Long categoryId;

    @ApiModelProperty("商品sku编号")
    private Long skuId;

    @ApiModelProperty("商品sku名字")
    private String skuName;

    @ApiModelProperty("商品sku图片")
    private String skuPic;

    @ApiModelProperty("商品sku价格")
    private BigDecimal skuPrice;

    @ApiModelProperty("商品购买的数量")
    private Integer skuQuantity;

    @ApiModelProperty("商品销售属性组合（JSON）")
    private String skuAttrsVals;

    @ApiModelProperty("商品促销分解金额")
    private BigDecimal promotionAmount;

    @ApiModelProperty("优惠券优惠分解金额")
    private BigDecimal couponAmount;

    @ApiModelProperty("积分优惠分解金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty("该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    @ApiModelProperty("赠送积分")
    private Integer giftIntegration;

    @ApiModelProperty("赠送成长值")
    private Integer giftGrowth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuPic() {
        return spuPic;
    }

    public void setSpuPic(String spuPic) {
        this.spuPic = spuPic;
    }

    public String getSpuBrand() {
        return spuBrand;
    }

    public void setSpuBrand(String spuBrand) {
        this.spuBrand = spuBrand;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuPic() {
        return skuPic;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(Integer skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

    public String getSkuAttrsVals() {
        return skuAttrsVals;
    }

    public void setSkuAttrsVals(String skuAttrsVals) {
        this.skuAttrsVals = skuAttrsVals;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
        "id = " + id +
        ", orderId = " + orderId +
        ", orderSn = " + orderSn +
        ", spuId = " + spuId +
        ", spuName = " + spuName +
        ", spuPic = " + spuPic +
        ", spuBrand = " + spuBrand +
        ", categoryId = " + categoryId +
        ", skuId = " + skuId +
        ", skuName = " + skuName +
        ", skuPic = " + skuPic +
        ", skuPrice = " + skuPrice +
        ", skuQuantity = " + skuQuantity +
        ", skuAttrsVals = " + skuAttrsVals +
        ", promotionAmount = " + promotionAmount +
        ", couponAmount = " + couponAmount +
        ", integrationAmount = " + integrationAmount +
        ", realAmount = " + realAmount +
        ", giftIntegration = " + giftIntegration +
        ", giftGrowth = " + giftGrowth +
        "}";
    }
}
