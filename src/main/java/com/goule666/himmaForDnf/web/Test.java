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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a",1);
        jsonObject.put("a1",1);
        jsonObject.put("a2",1);

        System.out.println(jsonObject.entrySet().size());
    }
}