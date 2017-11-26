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
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/createHimma", method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Boolean> getUserInfo(@RequestParam("typeId") Integer typeId,
                                      @RequestParam("name") String name,
                                      @RequestHeader("X_Auth_Token") String token) {
        return new Reply<>(himmaService.creatWorker(typeId, name, token));
    }

    @ApiOperation(value = "获取搬砖工人列表", notes = "获取搬砖工人列表")
    @RequestMapping(value = "/getHimmaList",method = RequestMethod.GET)
    @ApiImplicitParam(name = "X_Auth_Token", value = "token", required = true, dataType = "String", paramType = "header")
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<List<HimmaVO>> getUserInfo(@RequestHeader("X_Auth_Token") String token){
        return new Reply<>(himmaService.getWorkerList(token));
    }

    @ApiOperation(value = "搬砖开始", notes = "搬砖开始")
    @ApiImplicitParam(name = "himmaId", value = "搬砖工人id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/startHimma",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Boolean> startHimma(@RequestParam("himmaId")Integer himmaId){
        return new Reply<>(himmaService.startHimma(himmaId));
    }

    @ApiOperation(value = "搬砖结束", notes = "搬砖结束")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "himmaInfo", value = "搬砖收货信息", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "himmaId", value = "搬砖工人id", required = true, dataType = "int", paramType = "query")})
    @RequestMapping(value = "/endHimma", method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Boolean> endHimma(@RequestHeader("X_Auth_Token") String token,
                                   @RequestParam("himmaInfo") String himmaInfo,
                                   @RequestParam("himmaId") Integer himmaId) {
        return new Reply<>(himmaService.endHimma(himmaInfo,himmaId));
    }
}