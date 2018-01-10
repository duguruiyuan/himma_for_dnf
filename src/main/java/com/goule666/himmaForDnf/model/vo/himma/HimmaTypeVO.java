package com.goule666.himmaForDnf.model.vo.himma;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author niewenlong
 * @Date 2017/11/8 Time: 19:51
 * @Description 职业类型VO
 */
@ApiModel(value = "HimmaTypeVO", description = "职业类型集合")
public class HimmaTypeVO {

    @ApiModelProperty(value = "职业类型id")
    private Integer id;

    @ApiModelProperty(value = "职业类型名称")
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