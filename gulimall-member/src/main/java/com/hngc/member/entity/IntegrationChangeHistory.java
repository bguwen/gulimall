package com.hngc.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 积分变化历史记录
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("ums_integration_change_history")
@ApiModel(value = "IntegrationChangeHistory对象", description = "积分变化历史记录")
public class IntegrationChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("变化的值")
    private Integer changeCount;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("来源[0->购物；1->管理员修改;2->活动]")
    private Byte sourceTyoe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Byte getSourceTyoe() {
        return sourceTyoe;
    }

    public void setSourceTyoe(Byte sourceTyoe) {
        this.sourceTyoe = sourceTyoe;
    }

    @Override
    public String toString() {
        return "IntegrationChangeHistory{" +
        "id = " + id +
        ", memberId = " + memberId +
        ", createTime = " + createTime +
        ", changeCount = " + changeCount +
        ", note = " + note +
        ", sourceTyoe = " + sourceTyoe +
        "}";
    }
}
