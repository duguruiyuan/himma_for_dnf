package com.goule666.himmaForDnf.model.vo.login;

import com.goule666.himmaForDnf.utils.validator.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


/**
 * @author niewenlong
 * @Date 2017-10-25 14:12:09
 * @Description 用户登陆接口参数的实体类
 */
@ApiModel(value = "RequestLoginUser", description = "请求登录用户的信息")
public class RequestLoginUser implements Serializable {

    @ApiModelProperty(value = "用户名")
    @Phone
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    @NotBlank(message = "密码不能为空")
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
