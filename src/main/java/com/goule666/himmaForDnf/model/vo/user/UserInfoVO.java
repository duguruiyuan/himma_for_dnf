package com.goule666.himmaForDnf.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author niewenlong
 * @Date 2017/11/23 Time: 14:49
 * @Description
 */
@ApiModel(value = "UserInfoVO", description = "用户的详细信息")
public class UserInfoVO {

    @ApiModelProperty(value = "角色")
    private String role;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "动态图片")
    private String avatar;
    @ApiModelProperty(value = "介绍")
    private String introduction;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}