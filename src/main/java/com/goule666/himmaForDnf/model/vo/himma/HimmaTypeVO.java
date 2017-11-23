package com.goule666.himmaForDnf.model.vo.himma;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 职业类型VO
 */
public class HimmaTypeVO {
    /**
     * 职业编码
     * eg:yxms,hh
     */
    private Integer id;
    /**
     * 职业名称
     * eg:狱血魔神，花花，等等
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}