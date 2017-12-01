package com.goule666.himmaForDnf.model.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong 2017-10-19 19:43:38
 * @Description 系统用户表
 */
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserDO{
    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private String userName;
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
    /**
     * 动态图片
     */
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public UserDO(String userName, String password, Integer roleId, Date lastPasswordChange, Boolean enable) {
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.lastPasswordChange = lastPasswordChange;
        this.enable = enable;
    }

    public UserDO() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", lastPasswordChange=" + lastPasswordChange +
                ", enable=" + enable +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
