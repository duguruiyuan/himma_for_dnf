package com.goule666.dnf.service;

import com.goule666.dnf.model.domain.RoleDO;

public interface RoleService{

    int insert(RoleDO pojo);

    RoleDO findById(Integer id);

}
