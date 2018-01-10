package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.repository.RoleRepository;
import com.goule666.himmaForDnf.repository.UserRepository;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.model.vo.user.UserInfoVO;
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
    public UserInfoVO getUserInfo(String userName) {
        UserInfoVO userInfoVO = new UserInfoVO();
        UserDO userDO = userRepository.findByUserName(userName);
        userInfoVO.setRole(roleRepository.findById(userDO.getRoleId()).getRoleName());
        userInfoVO.setName(userDO.getUserName());
        userInfoVO.setAvatar(userDO.getAvatar());
        userInfoVO.setIntroduction(userDO.getUserName());
        return userInfoVO;
    }
}
