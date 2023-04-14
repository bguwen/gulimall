package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 优惠券信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_coupon")
@ApiModel(value = "Coupon对象", description = "优惠券信息")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]")
    private Boolean couponType;

    @ApiModelProperty("优惠券图片")
    private String couponImg;

    @ApiModelProperty("优惠卷名字")
    private String couponName;

    @ApiModelProperty("数量")
    private Integer num;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("每人限领张数")
    private Integer perLimit;

    @ApiModelProperty("使用门槛")
    private BigDecimal minPoint;

    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("使用类型[0->全场通用；1->指定分类；2->指定商品]")
    private Boolean useType;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("发行数量")
    private Integer publishCount;

    @ApiModelProperty("已使用数量")
    private Integer useCount;

    @ApiModelProperty("领取数量")
    private Integer receiveCount;

    @ApiModelProperty("可以领取的开始日期")
    private LocalDateTime enableStartTime;

    @ApiModelProperty("可以领取的结束日期")
    private LocalDateTime enableEndTime;

    @ApiModelProperty("优惠码")
    private String code;

    @ApiModelProperty("可以领取的会员等级[0->不限等级，其他-对应等级]")
    private Boolean memberLevel;

    @ApiModelProperty("发布状态[0-未发布，1-已发布]")
    private Boolean publish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCouponType() {
        return couponType;
    }

    public void setCouponType(Boolean couponType) {
        this.couponType = couponType;
    }

    public String getCouponImg() {
        return couponImg;
    }

    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPerLimit() {
        return perLimit;
    }

    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    public BigDecimal getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(BigDecimal minPoint) {
        this.minPoint = minPoint;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getUseType() {
        return useType;
    }

    public void setUseType(Boolean useType) {
        this.useType = useType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public LocalDateTime getEnableStartTime() {
        return enableStartTime;
    }

    public void setEnableStartTime(LocalDateTime enableStartTime) {
        this.enableStartTime = enableStartTime;
    }

    public LocalDateTime getEnableEndTime() {
        return enableEndTime;
    }

    public void setEnableEndTime(LocalDateTime enableEndTime) {
        this.enableEndTime = enableEndTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Boolean memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Coupon{" +
        "id = " + id +
        ", couponType = " + couponType +
        ", couponImg = " + couponImg +
        ", couponName = " + couponName +
        ", num = " + num +
        ", amount = " + amount +
        ", perLimit = " + perLimit +
        ", minPoint = " + minPoint +
        ", startTime = " + startTime +
        ", endTime = " + endTime +
        ", useType = " + useType +
        ", note = " + note +
        ", publishCount = " + publishCount +
        ", useCount = " + useCount +
        ", receiveCount = " + receiveCount +
        ", enableStartTime = " + enableStartTime +
        ", enableEndTime = " + enableEndTime +
        ", code = " + code +
        ", memberLevel = " + memberLevel +
        ", publish = " + publish +
        "}";
    }
}
