package com.hngc.ware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hn
 * @since 2023-04
 */
@TableName("undo_log")
@ApiModel(value = "UndoLog对象", description = "")
public class UndoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long branchId;

    private String xid;

    private String context;

    private byte[] rollbackInfo;

    private Integer logStatus;

    private LocalDateTime logCreated;

    private LocalDateTime logModified;

    private String ext;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public byte[] getRollbackInfo() {
        return rollbackInfo;
    }

    public void setRollbackInfo(byte[] rollbackInfo) {
        this.rollbackInfo = rollbackInfo;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public LocalDateTime getLogCreated() {
        return logCreated;
    }

    public void setLogCreated(LocalDateTime logCreated) {
        this.logCreated = logCreated;
    }

    public LocalDateTime getLogModified() {
        return logModified;
    }

    public void setLogModified(LocalDateTime logModified) {
        this.logModified = logModified;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "UndoLog{" +
        "id = " + id +
        ", branchId = " + branchId +
        ", xid = " + xid +
        ", context = " + context +
        ", rollbackInfo = " + rollbackInfo +
        ", logStatus = " + logStatus +
        ", logCreated = " + logCreated +
        ", logModified = " + logModified +
        ", ext = " + ext +
        "}";
    }
}
