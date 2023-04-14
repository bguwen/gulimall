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
 * 退款信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("oms_refund_info")
@ApiModel(value = "RefundInfo对象", description = "退款信息")
public class RefundInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("退款的订单")
    private Long orderReturnId;

    @ApiModelProperty("退款金额")
    private BigDecimal refund;

    @ApiModelProperty("退款交易流水号")
    private String refundSn;

    @ApiModelProperty("退款状态")
    private Boolean refundStatus;

    @ApiModelProperty("退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Byte refundChannel;

    private String refundContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderReturnId() {
        return orderReturnId;
    }

    public void setOrderReturnId(Long orderReturnId) {
        this.orderReturnId = orderReturnId;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    public Boolean getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Boolean refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Byte getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(Byte refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundContent() {
        return refundContent;
    }

    public void setRefundContent(String refundContent) {
        this.refundContent = refundContent;
    }

    @Override
    public String toString() {
        return "RefundInfo{" +
        "id = " + id +
        ", orderReturnId = " + orderReturnId +
        ", refund = " + refund +
        ", refundSn = " + refundSn +
        ", refundStatus = " + refundStatus +
        ", refundChannel = " + refundChannel +
        ", refundContent = " + refundContent +
        "}";
    }
}
