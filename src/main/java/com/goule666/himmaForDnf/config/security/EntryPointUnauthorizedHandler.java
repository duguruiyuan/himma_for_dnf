package com.goule666.himmaForDnf.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niewenlong
 * @Date: 2017/10/25 14:04
 * @Description: 没有登录就访问接口抛出错误提示。
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    /**
     * 未登录或无权限时触发的操作
     * 返回  {"code":401,"message":"你没有携带 token 或者 token 无效！","data":""}
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json形式的错误信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        httpServletResponse.getWriter().println("{\"statusCode\":401,\"statusMsg\":\"你没有携带 token 或者 token 无效！\",\"results\":\"\"}");
        httpServletResponse.getWriter().flush();
    }

}
