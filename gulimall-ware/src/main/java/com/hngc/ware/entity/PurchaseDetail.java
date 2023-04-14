package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("wms_purchase_detail")
@ApiModel(value = "PurchaseDetail对象", description = "")
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("采购单id")
    private Long purchaseId;

    @ApiModelProperty("采购商品id")
    private Long skuId;

    @ApiModelProperty("采购数量")
    private Integer skuNum;

    @ApiModelProperty("采购金额")
    private BigDecimal skuPrice;

    @ApiModelProperty("仓库id")
    private Long wareId;

    @ApiModelProperty("状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
        "id = " + id +
        ", purchaseId = " + purchaseId +
        ", skuId = " + skuId +
        ", skuNum = " + skuNum +
        ", skuPrice = " + skuPrice +
        ", wareId = " + wareId +
        ", status = " + status +
        "}";
    }
}
