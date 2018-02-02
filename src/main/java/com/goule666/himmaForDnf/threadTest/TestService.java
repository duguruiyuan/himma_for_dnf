package com.goule666.himmaForDnf.threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author niewenlong
 * Date 2017/12/20 Time: 9:16
 * Description
 */
public interface TestService {

    /**
     * 多线程测试
     * @return
     * @throws InterruptedException
     */
    Future<Integer> insertBatchThread() throws InterruptedException;

    /**
     * @Async测试
     * @return
     */
    void testAsync() throws InterruptedException;

    /**
     * 模拟卖出一张票操作
     * @return
     */
    void saleTicket() throws InterruptedException;
}