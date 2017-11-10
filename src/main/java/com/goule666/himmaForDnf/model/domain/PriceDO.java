package com.goule666.himmaForDnf.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/9 Time: 17:02
 * @Description 物品价格表
 */
@Entity
@Table(name = "price")
public class PriceDO {
    @Id
    @GeneratedValue
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    /**
     * 物品名称
     * eg:魔刹石
     */
    private String name;
    /**
     * 物品价格
     */
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        return "PriceDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}