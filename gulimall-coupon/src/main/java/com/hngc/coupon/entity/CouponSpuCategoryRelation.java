package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 优惠券分类关联
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_coupon_spu_category_relation")
@ApiModel(value = "CouponSpuCategoryRelation对象", description = "优惠券分类关联")
public class CouponSpuCategoryRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠券id")
    private Long couponId;

    @ApiModelProperty("产品分类id")
    private Long categoryId;

    @ApiModelProperty("产品分类名称")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CouponSpuCategoryRelation{" +
        "id = " + id +
        ", couponId = " + couponId +
        ", categoryId = " + categoryId +
        ", categoryName = " + categoryName +
        "}";
    }
}
