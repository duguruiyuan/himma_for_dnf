package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.Reply;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 13:59
 * @Description
 */
@RestController
@RequestMapping(value = "/himma")
public class HimmaController {
    @Autowired
    private HimmaService himmaService;

    @RequestMapping(value = "/createWorker",method = RequestMethod.POST)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply getUserInfo(@Param("typeId")Integer typeId,
                             @Param("name")String name,
                             @Param("token")String token){
        return null;
    }

    @RequestMapping(value = "/getWorkerList",method = RequestMethod.GET)
    @PreAuthorize(value = "hasAuthority('view')")
    public Reply getUserInfo(){
        return null;
    }
}