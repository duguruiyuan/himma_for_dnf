package com.goule666.houseforrent.service.impl;

import com.goule666.houseforrent.dao.RoleDao;
import com.goule666.houseforrent.model.domain.RoleDO;
import com.goule666.houseforrent.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public int insert(RoleDO pojo){
        return roleDao.insert(pojo);
    }

    @Override
    public RoleDO findById(Integer id) {
        return roleDao.findById(id);
    }

}
