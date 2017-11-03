package com.goule666.houseforrent.web;


import com.alibaba.fastjson.JSONObject;
import com.goule666.houseforrent.model.Reply;
import com.goule666.houseforrent.model.domain.UserDO;
import com.goule666.houseforrent.model.vo.RequestLoginUser;
import com.goule666.houseforrent.service.UserService;
import com.goule666.houseforrent.utils.TokenUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author niewenlong 2017-10-23 10:06:07
 */
@RestController
public class UserController {

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Reply login(@Valid RequestLoginUser requestLoginUser, BindingResult bindingResult){
        // 检查有没有输入用户名密码和格式对不对
        if (bindingResult.hasErrors()){
            return new Reply(400,"缺少参数或者参数格式不对");
        }
        UserDO userDO = userService.findByName(requestLoginUser.getUsername());
        Reply reply = checkAccount(requestLoginUser, userDO);
        //校验失败
        if (reply != null){
            return reply;
        }
        JSONObject needJSON = new JSONObject();
        needJSON.put(tokenHeader,tokenUtils.generateToken(userDO));
        return new Reply(needJSON);
    }

    private Reply checkAccount(RequestLoginUser requestLoginUser, UserDO userDO){
        if (userDO == null){
            return new Reply(434,"账号不存在！");
        }else {
            if (userDO.getEnable() == false){
                return new Reply(452,"账号在黑名单中");
            }
            if (!userDO.getPassword().equals(requestLoginUser.getPassword())){
                return new Reply(438,"密码错误！");
            }
        }
        return null;
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('admin')")//需要admin权限
    //@PreAuthorize(value = "hasRole('ROLE_USER')")//需要ROLE_USER身份
    public Reply admin(){
        return new Reply("欢迎admin用户");
    }

    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('user')")//需要admin权限
    public Reply info(@Param("token")String token){
        return new Reply(userService.findByName(tokenUtils.getUsernameFromToken(token)));
    }




}
