package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.RoleDO;

public interface RoleService{

    int insert(RoleDO pojo);

    RoleDO findById(Integer id);

}
