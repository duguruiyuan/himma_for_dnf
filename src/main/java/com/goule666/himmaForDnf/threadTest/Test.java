package com.goule666.himmaForDnf.threadTest;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author niewenlong
 * Date 2017/11/16 Time: 15:44
 * Description
 */
public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestThread testThread = new TestThread();
        new Thread(testThread,"窗口1").start();
        new Thread(testThread,"窗口2").start();
        new Thread(testThread,"窗口3").start();
        new Thread(testThread,"窗口4").start();
    }
}