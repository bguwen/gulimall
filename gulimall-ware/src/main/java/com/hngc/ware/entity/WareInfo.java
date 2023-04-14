package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 仓库信息
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("wms_ware_info")
@ApiModel(value = "WareInfo对象", description = "仓库信息")
public class WareInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("仓库名")
    private String name;

    @ApiModelProperty("仓库地址")
    private String address;

    @ApiModelProperty("区域编码")
    private String areacode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    @Override
    public String toString() {
        return "WareInfo{" +
        "id = " + id +
        ", name = " + name +
        ", address = " + address +
        ", areacode = " + areacode +
        "}";
    }
}
