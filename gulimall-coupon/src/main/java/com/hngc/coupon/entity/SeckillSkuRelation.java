package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 秒杀活动商品关联
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_seckill_sku_relation")
@ApiModel(value = "SeckillSkuRelation对象", description = "秒杀活动商品关联")
public class SeckillSkuRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("活动id")
    private Long promotionId;

    @ApiModelProperty("活动场次id")
    private Long promotionSessionId;

    @ApiModelProperty("商品id")
    private Long skuId;

    @ApiModelProperty("秒杀价格")
    private Long seckillPrice;

    @ApiModelProperty("秒杀总量")
    private Long seckillCount;

    @ApiModelProperty("每人限购数量")
    private Long seckillLimit;

    @ApiModelProperty("排序")
    private Integer seckillSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPromotionSessionId() {
        return promotionSessionId;
    }

    public void setPromotionSessionId(Long promotionSessionId) {
        this.promotionSessionId = promotionSessionId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Long seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Long getSeckillCount() {
        return seckillCount;
    }

    public void setSeckillCount(Long seckillCount) {
        this.seckillCount = seckillCount;
    }

    public Long getSeckillLimit() {
        return seckillLimit;
    }

    public void setSeckillLimit(Long seckillLimit) {
        this.seckillLimit = seckillLimit;
    }

    public Integer getSeckillSort() {
        return seckillSort;
    }

    public void setSeckillSort(Integer seckillSort) {
        this.seckillSort = seckillSort;
    }

    @Override
    public String toString() {
        return "SeckillSkuRelation{" +
        "id = " + id +
        ", promotionId = " + promotionId +
        ", promotionSessionId = " + promotionSessionId +
        ", skuId = " + skuId +
        ", seckillPrice = " + seckillPrice +
        ", seckillCount = " + seckillCount +
        ", seckillLimit = " + seckillLimit +
        ", seckillSort = " + seckillSort +
        "}";
    }
}
