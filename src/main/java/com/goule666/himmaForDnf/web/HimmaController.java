package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 13:59
 * @Description
 */
@Api(tags = "搬砖接口")
@RestController
@RequestMapping(value = "/himma")
public class HimmaController {
    @Autowired
    private HimmaService himmaService;

    @ApiOperation(value = "创建搬砖工", notes = "创建搬砖工人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "工人类型id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "X_Auth_Token", value = "token", required = true, dataType = "String", paramType = "header")})
    @RequestMapping(value = "/createWorker", method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Boolean> getUserInfo(@Param("typeId") Integer typeId,
                             @Param("name") String name,
                             @RequestHeader("X_Auth_Token") String token) {
        return new Reply<>(himmaService.creatWorker(typeId, name, token));
    }

    @ApiOperation(value = "获取搬砖工人列表", notes = "获取搬砖工人列表")
    @RequestMapping(value = "/getWorkerList",method = RequestMethod.GET)
    @ApiImplicitParam(name = "X_Auth_Token", value = "token", required = true, dataType = "String", paramType = "header")
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<List<HimmaVO>> getUserInfo(@RequestHeader("X_Auth_Token") String token){
        return new Reply<>(himmaService.getWorkerList(token));
    }
}