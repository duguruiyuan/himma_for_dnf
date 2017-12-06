package com.goule666.himmaForDnf.model.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author niewenlong
 * @Date 2017/11/9 Time: 17:02
 * @Description 物品价格表
 */
@Entity
@Table(name = "material")
public class MaterialDO extends BaseDO implements Serializable {
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

    @Override
    public String toString() {
        return "MaterialDO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}