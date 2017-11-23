package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 13:59
 * @Description 字典获取
 */
@RestController
public class DictController {

    @Autowired
    private DictService dictService;

    @RequestMapping(value = "/himma/getHimmaTypeList",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply getUserInfo(){
        return null;
    }
}
