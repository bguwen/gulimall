package com.hngc.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("ums_member_level")
@ApiModel(value = "MemberLevel对象", description = "会员等级")
public class MemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("等级名称")
    private String name;

    @ApiModelProperty("等级需要的成长值")
    private Integer growthPoint;

    @ApiModelProperty("是否为默认等级[0->不是；1->是]")
    private Byte defaultStatus;

    @ApiModelProperty("免运费标准")
    private BigDecimal freeFreightPoint;

    @ApiModelProperty("每次评价获取的成长值")
    private Integer commentGrowthPoint;

    @ApiModelProperty("是否有免邮特权")
    private Byte priviledgeFreeFreight;

    @ApiModelProperty("是否有会员价格特权")
    private Byte priviledgeMemberPrice;

    @ApiModelProperty("是否有生日特权")
    private Byte priviledgeBirthday;

    @ApiModelProperty("备注")
    private String note;

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

    public Integer getGrowthPoint() {
        return growthPoint;
    }

    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    public Byte getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Byte defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public BigDecimal getFreeFreightPoint() {
        return freeFreightPoint;
    }

    public void setFreeFreightPoint(BigDecimal freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    public Integer getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    public void setCommentGrowthPoint(Integer commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    public Byte getPriviledgeFreeFreight() {
        return priviledgeFreeFreight;
    }

    public void setPriviledgeFreeFreight(Byte priviledgeFreeFreight) {
        this.priviledgeFreeFreight = priviledgeFreeFreight;
    }

    public Byte getPriviledgeMemberPrice() {
        return priviledgeMemberPrice;
    }

    public void setPriviledgeMemberPrice(Byte priviledgeMemberPrice) {
        this.priviledgeMemberPrice = priviledgeMemberPrice;
    }

    public Byte getPriviledgeBirthday() {
        return priviledgeBirthday;
    }

    public void setPriviledgeBirthday(Byte priviledgeBirthday) {
        this.priviledgeBirthday = priviledgeBirthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MemberLevel{" +
        "id = " + id +
        ", name = " + name +
        ", growthPoint = " + growthPoint +
        ", defaultStatus = " + defaultStatus +
        ", freeFreightPoint = " + freeFreightPoint +
        ", commentGrowthPoint = " + commentGrowthPoint +
        ", priviledgeFreeFreight = " + priviledgeFreeFreight +
        ", priviledgeMemberPrice = " + priviledgeMemberPrice +
        ", priviledgeBirthday = " + priviledgeBirthday +
        ", note = " + note +
        "}";
    }
}
