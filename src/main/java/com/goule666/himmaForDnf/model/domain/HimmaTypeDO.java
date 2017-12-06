package com.goule666.himmaForDnf.model.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:30
 * @Description 搬砖工人类型表
 */
@Entity
@Table(name = "himma_type")
public class HimmaTypeDO extends BaseDO{
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

    @Override
    public String toString() {
        return "HimmaTypeDO{" +
                "name='" + name + '\'' +
                '}';
    }
}