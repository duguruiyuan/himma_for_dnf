package com.goule666.houseforrent.config.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niewenlong
 * @Date: 2017/10/25 14:04
 * @Description: 没有权限的时候抛出异常
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //返回json形式的错误信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        httpServletResponse.getWriter().println("{\"statusCode\":403,\"statusMsg\":\"你没有权限访问呀！\",\"results\":\"\"}");
        httpServletResponse.getWriter().flush();
    }
}
