package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.vo.user.UserInfoVO;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author niewenlong
 * @Date 2017/11/22 Time: 19:11
 * @Description 获取用户信息
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtils tokenUtils;

    @ApiOperation(value = "获取用户信息", notes = "登录完成之后返回用户信息")
    @ApiImplicitParam(name = "X_Auth_Token", value = "token", required = true, dataType = "String" ,paramType = "header")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<UserInfoVO> getUserInfo(@RequestHeader("X_Auth_Token")String token) {
        return new Reply(userService.getUserInfo(tokenUtils.getUsernameFromToken(token)));
    }
}