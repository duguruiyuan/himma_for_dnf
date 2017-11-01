package com.goule666.dnf.service;

import com.goule666.dnf.model.domain.UserDO;

public interface UserService{

    int insert(UserDO pojo);

    UserDO findByName(String userName);
}
