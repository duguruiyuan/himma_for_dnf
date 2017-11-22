package com.goule666.himmaForDnf.model.vo;

import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 工人VO
 */
public class WorkerVO {
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 工人类型
     */
    private String workerType;
    /**
     * 姓名
     */
    private String workerName;
    /**
     * 剩余疲劳值
     */
    private Integer surplusPl;
    /**
     * 状态 0：停用，1：启用
     */
    private Integer status;
    /**
     * 当天收益
     */
    private Double todayProfit;
    /**
     * 耗时
     */
    private String timeUsed;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
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

    public Double getTodayProfit() {
        return todayProfit;
    }

    public void setTodayProfit(Double todayProfit) {
        this.todayProfit = todayProfit;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }
}