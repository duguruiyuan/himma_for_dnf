package com.goule666.houseforrent.service.impl;

import com.goule666.houseforrent.dao.UserDao;
import com.goule666.houseforrent.model.domain.UserDO;
import com.goule666.houseforrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public int insert(UserDO pojo) {
        return userDao.insert(pojo);
    }

    @Override
    public UserDO findByName(String userName) {
        return userDao.findByName(userName);
    }
}
