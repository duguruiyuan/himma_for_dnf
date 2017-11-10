package com.goule666.himmaForDnf.model.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/9 Time: 17:06
 * @Description 搬砖记录表
 */
@Entity
@Table(name = "himma_record")
public class HimmaRecordDO{
    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    /**
     * 工人id
     */
    private Integer workerId;
    /**
     * 搬砖开始时间
     */
    private Date startTime;
    /**
     * 搬砖结束时间
     */
    private Date endTime;
    /**
     * 耗时
     */
    private String timeUsed;
    /**
     * 魔刹石个数
     */
    private Integer mssCount;
    /**
     * 挑战书个数
     */
    private Integer tzsCount;
    /**
     * 无色个数
     */
    private Integer wsCount;
    /**
     * 遗忘陨石个数
     */
    private Integer ywysCount;
    /**
     * 意外收获
     */
    private Double ywsh;
    /**
     * 总收益
     */
    private Double profit;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Integer getMssCount() {
        return mssCount;
    }

    public void setMssCount(Integer mssCount) {
        this.mssCount = mssCount;
    }

    public Integer getTzsCount() {
        return tzsCount;
    }

    public void setTzsCount(Integer tzsCount) {
        this.tzsCount = tzsCount;
    }

    public Integer getWsCount() {
        return wsCount;
    }

    public void setWsCount(Integer wsCount) {
        this.wsCount = wsCount;
    }

    public Integer getYwysCount() {
        return ywysCount;
    }

    public void setYwysCount(Integer ywysCount) {
        this.ywysCount = ywysCount;
    }

    public Double getYwsh() {
        return ywsh;
    }

    public void setYwsh(Double ywsh) {
        this.ywsh = ywsh;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

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

    @Override
    public String toString() {
        return "HimmaRecordDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", workerId=" + workerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", timeUsed='" + timeUsed + '\'' +
                ", mssCount=" + mssCount +
                ", tzsCount=" + tzsCount +
                ", wsCount=" + wsCount +
                ", ywysCount=" + ywysCount +
                ", ywsh=" + ywsh +
                ", profit=" + profit +
                '}';
    }
}