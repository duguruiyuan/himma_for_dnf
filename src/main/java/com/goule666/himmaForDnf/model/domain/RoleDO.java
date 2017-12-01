package com.goule666.himmaForDnf.model.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niewenlong 2017-10-19 19:43:38
 * @Description 系统角色表
 */
@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleDO {
    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色对应的权限
     */
    private String auth;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleDO(String roleName, String auth) {
        this.roleName = roleName;
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public RoleDO() {
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
        return "RoleDO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", roleName='" + roleName + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
