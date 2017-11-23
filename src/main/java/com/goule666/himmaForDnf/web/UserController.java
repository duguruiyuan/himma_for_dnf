package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niewenlong
 * @Date 2017/11/22 Time: 19:11
 * @Description 获取用户信息
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtils tokenUtils;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply getUserInfo(@Param("token")String token){
        return null;
    }
}