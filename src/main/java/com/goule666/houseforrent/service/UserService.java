package com.goule666.houseforrent.service;

import com.goule666.houseforrent.model.domain.UserDO;

public interface UserService{

    int insert(UserDO pojo);

    UserDO findByName(String userName);
}
