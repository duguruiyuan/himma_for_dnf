package com.goule666.himmaForDnf.model.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 搬砖工人
 */
@Entity
@Table(name = "worker")
public class WorkerDO{
    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 搬砖角色名称
     */
    private String workerName;
    /**
     * 角色类型id
     */
    private Integer workerTypeId;
    /**
     * 剩余疲劳值
     */
    private Integer surplusPl;
    /**
     * 状态 0：停用，1：启用
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getWorkerTypeId() {
        return workerTypeId;
    }

    public void setWorkerTypeId(Integer workerTypeId) {
        this.workerTypeId = workerTypeId;
    }

    public Integer getSurplusPl() {
        return surplusPl;
    }

    public void setSurplusPl(Integer surplusPl) {
        this.surplusPl = surplusPl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkerDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userId=" + userId +
                ", workerName='" + workerName + '\'' +
                ", workerTypeId=" + workerTypeId +
                ", surplusPl=" + surplusPl +
                ", status=" + status +
                '}';
    }
}