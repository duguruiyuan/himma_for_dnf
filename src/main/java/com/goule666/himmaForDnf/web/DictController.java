package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.model.vo.himma.HimmaTypeVO;
import com.goule666.himmaForDnf.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author niewenlong
 * Date 2017/11/10 Time: 13:59
 * Description 字典获取
 */
@Api(tags = "字典获取")
@RestController
public class DictController {

    @Resource
    private DictService dictService;

    @ApiOperation(value = "获取职业类型", notes = "获取下拉框所有的职业类型")
    @RequestMapping(value = "/himma/getHimmaTypeList",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply<List<HimmaTypeVO>> getUserInfo(){
        return new Reply<>(dictService.getHimmaTypeList());
    }
}
