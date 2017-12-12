package com.goule666.himmaForDnf.web;


import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niewenlong
 * Date 2017/11/16 Time: 15:44
 * Description
 */
public class Test {
    public static void main(String[] args) {
        Double num3 = 100.0215410d;
        BigDecimal num4 = new BigDecimal(num3.toString());
        Map<String, BigDecimal> resultMap = new HashMap<>();
        resultMap.put("a", new BigDecimal(4d));
        Object actualMoney = resultMap.get("a");
        if (actualMoney != null) {
            System.out.println(num4.add(new BigDecimal(actualMoney.toString())).stripTrailingZeros());
        }
    }
}