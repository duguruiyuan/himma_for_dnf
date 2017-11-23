package com.goule666.himmaForDnf.model.vo.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author niewenlong
 * @Date 2017-10-25 14:12:09
 * @Description 用户登陆接口参数的实体类
 */
@ApiModel(value = "RequestLoginUser", description = "用户请求参数")
public class RequestLoginUser {

    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

    public RequestLoginUser() {
    }

    public String getUsername() {
        return username;
    }

    public RequestLoginUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequestLoginUser setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "RequestLoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
