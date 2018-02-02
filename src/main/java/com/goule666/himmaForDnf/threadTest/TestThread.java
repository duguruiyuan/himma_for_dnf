package com.goule666.himmaForDnf.threadTest;

import org.springframework.context.ApplicationContext;

/**
 * @author niewenlong
 * Date 2018/1/17 Time: 10:42
 * Description
 */
public class TestThread implements Runnable {

    private ApplicationContext applicationContext;

    @Override
    public void run() {
        /*//从数据库读取票 然后卖出
        TestService testService = (TestService) applicationContext.getBean("testService");
        //开始卖票
        Boolean flg = testService.saleTicket();
        if(flg) {
            System.out.println(Thread.currentThread().getName() + "卖出一张票");
        }*/

    }
}