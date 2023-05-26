package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
@Data
@TableName("wms_purchase_detail")
@ApiModel(value = "PurchaseDetail对象", description = "")
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Null(groups = AddGroup.class)
    @NotNull(groups = {UpdateGroup.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("采购单id")
    private Long purchaseId;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("采购商品id")
    private Long skuId;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("采购数量")
    private Integer skuNum;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("采购金额")
    private BigDecimal skuPrice;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("仓库id")
    private Long wareId;
    @NotNull(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;

}
