package com.goule666.himmaForDnf.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:30
 * @Description 搬砖工人类型表
 */
@Entity
@Table(name = "himma_type")
public class HimmaTypeDO {
    @Id
    @GeneratedValue
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    /**
     * 职业名称
     * eg:狱血魔神，花花，等等
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "HimmaTypeDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                '}';
    }
}