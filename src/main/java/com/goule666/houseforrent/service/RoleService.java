package com.goule666.houseforrent.service;

import com.goule666.houseforrent.model.domain.RoleDO;

public interface RoleService{

    int insert(RoleDO pojo);

    RoleDO findById(Integer id);

}
