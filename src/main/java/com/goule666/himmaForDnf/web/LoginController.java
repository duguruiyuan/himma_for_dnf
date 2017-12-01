package com.goule666.himmaForDnf.web;


import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.model.vo.login.RequestLoginUser;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.enums.ResponseInfo;
import com.goule666.himmaForDnf.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author niewenlong
 * @Date 2017/11/22 Time: 19:11
 * @Description 处理登录请求
 */
@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "根据用户名和密码登录并返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 434, message = "账号不存在"),
            @ApiResponse(code = 452, message = "黑名单"),
            @ApiResponse(code = 438, message = "密码错误")
    })
    public Reply login(@RequestBody @Valid RequestLoginUser requestLoginUser) {
        UserDO userDO = userService.findByName(requestLoginUser.getUsername());
        Reply reply = checkAccount(requestLoginUser, userDO);
        if (reply != null) {
            return reply;
        }
        JSONObject needJSON = new JSONObject();
        needJSON.put(tokenHeader, tokenUtils.generateToken(userDO));
        return new Reply<>(needJSON);
    }

    private Reply checkAccount(RequestLoginUser requestLoginUser, UserDO userDO) {
        if (userDO == null) {
            return new Reply(ResponseInfo.NO_ACCOUNT.getState(), ResponseInfo.NO_ACCOUNT.getStateInfo());
        } else {
            if (!userDO.getEnable()) {
                return new Reply(ResponseInfo.NO_ENABLE.getState(), ResponseInfo.NO_ENABLE.getStateInfo());
            }
            if (!userDO.getPassword().equals(requestLoginUser.getPassword())) {
                return new Reply(ResponseInfo.WRONG_PASSWORD.getState(), ResponseInfo.WRONG_PASSWORD.getStateInfo());
            }
        }
        return null;
    }

}
