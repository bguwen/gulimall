package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 秒杀商品通知订阅
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_seckill_sku_notice")
@ApiModel(value = "SeckillSkuNotice对象", description = "秒杀商品通知订阅")
public class SeckillSkuNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("sku_id")
    private Long skuId;

    @ApiModelProperty("活动场次id")
    private Long sessionId;

    @ApiModelProperty("订阅时间")
    private LocalDateTime subcribeTime;

    @ApiModelProperty("发送时间")
    private LocalDateTime sendTime;

    @ApiModelProperty("通知方式[0-短信，1-邮件]")
    private Boolean noticeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getSubcribeTime() {
        return subcribeTime;
    }

    public void setSubcribeTime(LocalDateTime subcribeTime) {
        this.subcribeTime = subcribeTime;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Boolean noticeType) {
        this.noticeType = noticeType;
    }

    @Override
    public String toString() {
        return "SeckillSkuNotice{" +
        "id = " + id +
        ", memberId = " + memberId +
        ", skuId = " + skuId +
        ", sessionId = " + sessionId +
        ", subcribeTime = " + subcribeTime +
        ", sendTime = " + sendTime +
        ", noticeType = " + noticeType +
        "}";
    }
}
