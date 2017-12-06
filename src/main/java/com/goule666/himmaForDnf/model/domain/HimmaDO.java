package com.goule666.himmaForDnf.model.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 搬砖工人表
 */
@Entity
@Table(name = "himma")
public class HimmaDO extends BaseDO {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 搬砖角色名称
     */
    private String name;
    /**
     * 角色类型id
     */
    private Integer typeId;
    /**
     * 剩余疲劳值
     */
    private Integer surplusPl;
    /**
     * 状态 0：停用，1：启用
     */
    private Integer status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        return "HimmaDO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", surplusPl=" + surplusPl +
                ", status=" + status +
                '}';
    }
}