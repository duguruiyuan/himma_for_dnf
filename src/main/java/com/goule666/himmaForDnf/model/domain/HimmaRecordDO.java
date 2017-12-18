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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    /**
     * 搬砖工人id
     */
    private Integer himmaId;
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
     * 材料信息
     */
    private String himmaInfo;
    /**
     * 总收益
     */
    private Double profit;


    public Integer getHimmaId() {
        return himmaId;
    }

    public void setHimmaId(Integer himmaId) {
        this.himmaId = himmaId;
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

    public String getHimmaInfo() {
        return himmaInfo;
    }

    public void setHimmaInfo(String himmaInfo) {
        this.himmaInfo = himmaInfo;
    }


    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                ", himmaId=" + himmaId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", timeUsed='" + timeUsed + '\'' +
                ", himmaInfo='" + himmaInfo + '\'' +
                ", profit=" + profit +
                '}';
    }
}