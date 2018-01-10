package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.model.vo.user.UserInfoVO;

public interface UserService{

    int insert(UserDO pojo);

    UserDO findByName(String userName);

    /**
     * 根据token获取登录信息
     * @param userName
     * @return
     */
    UserInfoVO getUserInfo(String userName);
}
