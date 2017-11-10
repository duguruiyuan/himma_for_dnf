package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.RoleRepository;
import com.goule666.himmaForDnf.model.domain.RoleDO;
import com.goule666.himmaForDnf.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleDao;

    @Override
    public int insert(RoleDO pojo){
        return roleDao.save(pojo).getId();
    }

    @Override
    public RoleDO findById(Integer id) {
        return roleDao.findById(id);
    }

}
