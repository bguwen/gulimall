package com.hngc.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
import java.math.BigDecimal;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@Data
@TableName("ums_member_level")
@ApiModel(value = "MemberLevel对象", description = "会员等级")
public class MemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Null(groups = {AddGroup.class})
    @NotNull(groups = {UpdateGroup.class})
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("等级名称")
    private String name;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("等级需要的成长值")
    private Integer growthPoint;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("是否为默认等级[0->不是；1->是]")
    private Byte defaultStatus;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("免运费标准")
    private BigDecimal freeFreightPoint;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("每次评价获取的成长值")
    private Integer commentGrowthPoint;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("是否有免邮特权")
    private Byte priviledgeFreeFreight;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("是否有会员价格特权")
    private Byte priviledgeMemberPrice;
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("是否有生日特权")
    private Byte priviledgeBirthday;
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("逻辑删除[0：未删除，1：已删除]")
    @Null(groups = {AddGroup.class})
    @TableLogic
    private Integer isDelete;
}
