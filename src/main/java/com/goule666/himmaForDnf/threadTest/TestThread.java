package com.goule666.himmaForDnf.threadTest;


/**
 * @author niewenlong
 * Date 2018/1/17 Time: 10:42
 * Description
 */
public class TestThread implements Runnable {
    private int ticket = 10;


    @Override
    public void run() {
        while(ticket > 0){
            synchronized (this){
                if(ticket > 0){
                    ticket--;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖票，还剩下" + ticket + "张");
                }else {
                    System.out.println("票已经卖完");
                }
            }
        }

    }
}