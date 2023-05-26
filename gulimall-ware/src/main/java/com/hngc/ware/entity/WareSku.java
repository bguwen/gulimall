package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * <p>
 * 商品库存
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Data
@TableName("wms_ware_sku")
@ApiModel(value = "WareSku对象", description = "商品库存")
public class WareSku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Null(groups = {AddGroup.class})
    @NotNull(groups = {UpdateGroup.class})
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("sku_id")
    private Long skuId;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("仓库id")
    private Long wareId;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("库存数")
    private Integer stock;
    @Null(groups = { AddGroup.class,UpdateGroup.class})
    @ApiModelProperty("sku_name")
    private String skuName;

    @ApiModelProperty("锁定库存")
    private Integer stockLocked;

}
