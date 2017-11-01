package com.goule666.houseforrent.model.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

/**
 * @author niewenlong 2017-10-19 19:43:38
 */

public class UserDO extends BaseDO{
    private String username;
    private String password;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 上一次修改密码的时间
     */
    private Date lastPasswordChange;
    /**
     * 是否黑名单
     */
    private Boolean enable;

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public UserDO(String username, String password, Integer roleId, Date lastPasswordChange, Boolean enable) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.lastPasswordChange = lastPasswordChange;
        this.enable = enable;
    }

    public UserDO() {
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", lastPasswordChange='" + lastPasswordChange + '\'' +
                ", enable=" + enable +
                '}';
    }

}
