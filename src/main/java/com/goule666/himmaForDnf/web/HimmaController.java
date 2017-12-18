package com.goule666.himmaForDnf.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.model.vo.himma.MaterialVO;
import com.goule666.himmaForDnf.model.vo.himma.MaterialVOForm;
import com.goule666.himmaForDnf.service.HimmaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author niewenlong
 * Date 2017/11/10 Time: 13:59
 * Description
 */
@Api(tags = "搬砖接口")
@RestController
@RequestMapping(value = "/himma")
public class HimmaController {
    @Resource
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
    @ApiImplicitParam(name = "X_Auth_Token", value = "token", required = true, dataType = "String", paramType = "header")
    @RequestMapping(value = "/getHimmaList",method = RequestMethod.GET)
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
            @ApiImplicitParam(name = "himmaInfo", value = "搬砖收益详细信息", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "himmaId", value = "搬砖工人id", required = true, dataType = "int", paramType = "query")})
    @RequestMapping(value = "/endHimma", method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Double> endHimma(@RequestParam(value = "himmaInfo") String himmaInfo,
                                  @RequestParam(value = "himmaId") Integer himmaId) {
        return new Reply<>(himmaService.endHimma(himmaInfo, himmaId));
    }

    @ApiOperation(value = "获取下拉框内容（搬砖材料）", notes = "获取下拉框内容（搬砖材料）")
    @RequestMapping(value = "/getMaterialInfo", method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<List<MaterialVO>> getMaterialInfo() {
        return new Reply<>(himmaService.getMaterialInfo());
    }


    @ApiOperation(value = "修改材料价格", notes = "修改材料价格")
    @RequestMapping(value = "/changeMaterialPrice", method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<Boolean> changeMaterialPrice(@RequestBody List<MaterialVO> materialVOList) {
        return new Reply<>(himmaService.changeMaterialPrice(materialVOList));
    }
}