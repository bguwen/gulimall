package com.hngc.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 会员收藏的专题活动
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("ums_member_collect_subject")
@ApiModel(value = "MemberCollectSubject对象", description = "会员收藏的专题活动")
public class MemberCollectSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("subject_id")
    private Long subjectId;

    @ApiModelProperty("subject_name")
    private String subjectName;

    @ApiModelProperty("subject_img")
    private String subjectImg;

    @ApiModelProperty("活动url")
    private String subjectUrll;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectImg() {
        return subjectImg;
    }

    public void setSubjectImg(String subjectImg) {
        this.subjectImg = subjectImg;
    }

    public String getSubjectUrll() {
        return subjectUrll;
    }

    public void setSubjectUrll(String subjectUrll) {
        this.subjectUrll = subjectUrll;
    }

    @Override
    public String toString() {
        return "MemberCollectSubject{" +
        "id = " + id +
        ", subjectId = " + subjectId +
        ", subjectName = " + subjectName +
        ", subjectImg = " + subjectImg +
        ", subjectUrll = " + subjectUrll +
        "}";
    }
}
