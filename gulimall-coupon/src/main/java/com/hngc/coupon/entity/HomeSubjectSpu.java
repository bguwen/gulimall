package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 专题商品
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_home_subject_spu")
@ApiModel(value = "HomeSubjectSpu对象", description = "专题商品")
public class HomeSubjectSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专题名字")
    private String name;

    @ApiModelProperty("专题id")
    private Long subjectId;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("排序")
    private Integer sort;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "HomeSubjectSpu{" +
        "id = " + id +
        ", name = " + name +
        ", subjectId = " + subjectId +
        ", spuId = " + spuId +
        ", sort = " + sort +
        "}";
    }
}
