package com.goule666.himmaForDnf.threadTest;


import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.domain.UserDO;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author niewenlong
 * Date 2017/11/16 Time: 15:44
 * Description
 */
public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*Long start = System.currentTimeMillis();
        List<UserDO> userDOList = new ArrayList<>();
        for(int i = 0;i<9999;i++){
            UserDO u = new UserDO();
            u.setUserName("goule666");
            u.setPassword("goule666");
            userDOList.add(u);
        }
        UserDO u = new UserDO();
        u.setUserName("goule777");
        u.setPassword("goule777");
        userDOList.add(u);


        AsyncTest asyncTest = new AsyncTest();
        Future<Integer> aThread = asyncTest.checkNameAndPassword(userDOList);
        Future<Integer> bThread = asyncTest.checkNameAndPassword(userDOList);
        while (true) {
            if (aThread.isDone()) {
                break;
            }
        }
        System.out.println(aThread.get());
        System.out.println("校验用户名和密码一共消耗：" + (System.currentTimeMillis() - start));*/
        UserDO userDO = new UserDO();
        System.out.println(userDO == null);
    }
}