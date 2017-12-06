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
public class RoleDO extends BaseDO {
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

    @Override
    public String toString() {
        return "RoleDO{" +
                "roleName='" + roleName + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
