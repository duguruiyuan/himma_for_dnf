package com.goule666.himmaForDnf.web;


import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/16 Time: 15:44
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        List<JSONObject> packItemInfo = new ArrayList<>();
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("a1", "a1");
        packItemInfo.add(resultJSON);
        if (1 == 1) {
            JSONObject json = (packItemInfo.get(0));
            json.put("a1", "b1");
        }

        List<com.alibaba.fastjson.JSONObject> packItemInfo1 = new ArrayList<>();
        com.alibaba.fastjson.JSONObject resultJSON1 = new com.alibaba.fastjson.JSONObject();
        resultJSON1.put("a1", "a1");
        packItemInfo1.add(resultJSON1);
        if (1 == 1) {
            com.alibaba.fastjson.JSONObject json = JSON.parseObject(packItemInfo1.get(0).toString());
            json.put("a1", "b1");
        }
        System.out.println(packItemInfo.toString());
        System.out.println(packItemInfo1.toString());

        /*String str = "[1,1,1]";
        RoleDO roleDO = new RoleDO();
        roleDO.setId(1);
        roleDO.setCreatedAt(new Date());
        roleDO.setUpdatedAt(new Date());
        roleDO.setRoleName("a");
        roleDO.setAuth(str);
        JSONObject json1 = JSONObject.fromObject(roleDO);
        System.out.println(json1);
*/
    }
}