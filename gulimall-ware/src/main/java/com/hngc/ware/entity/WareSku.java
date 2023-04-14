package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品库存
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("wms_ware_sku")
@ApiModel(value = "WareSku对象", description = "商品库存")
public class WareSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    private Long skuId;

    @ApiModelProperty("仓库id")
    private Long wareId;

    @ApiModelProperty("库存数")
    private Integer stock;

    @ApiModelProperty("sku_name")
    private String skuName;

    @ApiModelProperty("锁定库存")
    private Integer stockLocked;

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

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getStockLocked() {
        return stockLocked;
    }

    public void setStockLocked(Integer stockLocked) {
        this.stockLocked = stockLocked;
    }

    @Override
    public String toString() {
        return "WareSku{" +
        "id = " + id +
        ", skuId = " + skuId +
        ", wareId = " + wareId +
        ", stock = " + stock +
        ", skuName = " + skuName +
        ", stockLocked = " + stockLocked +
        "}";
    }
}
