package com.goule666.himmaForDnf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.dao.RoleRepository;
import com.goule666.himmaForDnf.dao.UserRepository;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niewenlong
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public int insert(UserDO pojo) {
        return userRepository.save(pojo).getId();
    }

    @Override
    public UserDO findByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public JSONObject getUserInfo(String userName) {
        JSONObject need = new JSONObject();
        UserDO userDO = userRepository.findByUserName(userName);
        need.put("role", roleRepository.findById(userDO.getRoleId()).getRoleName());
        need.put("name", userDO.getUserName());
        need.put("avatar", userDO.getAvatar());
        need.put("introduction", userDO.getUserName());
        return need;
    }
}
