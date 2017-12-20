package com.goule666.himmaForDnf.service;

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
}