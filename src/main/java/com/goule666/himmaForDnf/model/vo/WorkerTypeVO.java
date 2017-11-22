package com.goule666.himmaForDnf.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 职业类型VO
 */
public class WorkerTypeVO {
    /**
     * 职业编码
     * eg:yxms,hh
     */
    private String code;
    /**
     * 职业名称
     * eg:狱血魔神，花花，等等
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}