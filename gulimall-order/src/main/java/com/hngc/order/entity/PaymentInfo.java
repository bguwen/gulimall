package com.hngc.order.entity;

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
 * 支付信息表
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("oms_payment_info")
@ApiModel(value = "PaymentInfo对象", description = "支付信息表")
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单号（对外业务号）")
    private String orderSn;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("支付宝交易流水号")
    private String alipayTradeNo;

    @ApiModelProperty("支付总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("交易内容")
    private String subject;

    @ApiModelProperty("支付状态")
    private String paymentStatus;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("确认时间")
    private LocalDateTime confirmTime;

    @ApiModelProperty("回调内容")
    private String callbackContent;

    @ApiModelProperty("回调时间")
    private LocalDateTime callbackTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getCallbackContent() {
        return callbackContent;
    }

    public void setCallbackContent(String callbackContent) {
        this.callbackContent = callbackContent;
    }

    public LocalDateTime getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(LocalDateTime callbackTime) {
        this.callbackTime = callbackTime;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
        "id = " + id +
        ", orderSn = " + orderSn +
        ", orderId = " + orderId +
        ", alipayTradeNo = " + alipayTradeNo +
        ", totalAmount = " + totalAmount +
        ", subject = " + subject +
        ", paymentStatus = " + paymentStatus +
        ", createTime = " + createTime +
        ", confirmTime = " + confirmTime +
        ", callbackContent = " + callbackContent +
        ", callbackTime = " + callbackTime +
        "}";
    }
}
