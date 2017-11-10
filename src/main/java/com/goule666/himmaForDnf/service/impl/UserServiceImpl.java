package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.UserRepository;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;


    @Override
    public int insert(UserDO pojo) {
        return userDao.save(pojo).getId();
    }

    @Override
    public UserDO findByName(String userName) {
        return userDao.findByUserName(userName);
    }
}
