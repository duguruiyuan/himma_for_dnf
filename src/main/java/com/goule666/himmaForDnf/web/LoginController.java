package com.goule666.himmaForDnf.web;


import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.model.vo.RequestLoginUser;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 处理登录请求
 * @author niewenlong 2017-10-23 10:06:07
 */
@RestController
public class LoginController {

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Reply login(@Valid RequestLoginUser requestLoginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new Reply(400, "缺少参数或者参数格式不对");
        }
        UserDO userDO = userService.findByName(requestLoginUser.getUsername());
        Reply reply = checkAccount(requestLoginUser, userDO);
        if (reply != null) {
            return reply;
        }
        JSONObject needJSON = new JSONObject();
        needJSON.put(tokenHeader, tokenUtils.generateToken(userDO));
        return new Reply(needJSON);
    }

    private Reply checkAccount(RequestLoginUser requestLoginUser, UserDO userDO) {
        if (userDO == null) {
            return new Reply(434, "账号不存在！");
        } else {
            if (userDO.getEnable() == false) {
                return new Reply(452, "账号在黑名单中");
            }
            if (!userDO.getPassword().equals(requestLoginUser.getPassword())) {
                return new Reply(438, "密码错误！");
            }
        }
        return null;
    }
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply getUserInfo(@Param("token")String token){
        return new Reply(userService.getUserInfo(tokenUtils.getUsernameFromToken(token)));
    }

}
