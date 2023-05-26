package com.hngc.feign.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Data
@ApiModel(value = "SkuInfo对象", description = "sku信息")
public class SkuInfoTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("skuId")
    private Long skuId;

    @ApiModelProperty("spuId")
    private Long spuId;

    @ApiModelProperty("sku名称")
    private String skuName;

}
