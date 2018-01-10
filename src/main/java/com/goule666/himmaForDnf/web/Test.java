package com.goule666.himmaForDnf.web;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.domain.UserDO;

import java.math.BigDecimal;
import java.sql.Date;
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
    static class MyThread  extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                Thread.interrupted();
                System.out.println(123);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyThread1  extends Thread{
        @Override
        public void run() {
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> c = new ArrayList<>();
        c.addAll(a);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(4);
        b.removeAll(c);
        System.out.println(c);
    }
}