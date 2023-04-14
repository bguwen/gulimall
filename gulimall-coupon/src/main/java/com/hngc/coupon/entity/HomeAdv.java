package com.hngc.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 首页轮播广告
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("sms_home_adv")
@ApiModel(value = "HomeAdv对象", description = "首页轮播广告")
public class HomeAdv implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("图片地址")
    private String pic;

    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("状态")
    private Boolean status;

    @ApiModelProperty("点击数")
    private Integer clickCount;

    @ApiModelProperty("广告详情连接地址")
    private String url;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("发布者")
    private Long publisherId;

    @ApiModelProperty("审核者")
    private Long authId;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "HomeAdv{" +
        "id = " + id +
        ", name = " + name +
        ", pic = " + pic +
        ", startTime = " + startTime +
        ", endTime = " + endTime +
        ", status = " + status +
        ", clickCount = " + clickCount +
        ", url = " + url +
        ", note = " + note +
        ", sort = " + sort +
        ", publisherId = " + publisherId +
        ", authId = " + authId +
        "}";
    }
}
