package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.UserDO;

public interface UserService{

    int insert(UserDO pojo);

    UserDO findByName(String userName);
}
