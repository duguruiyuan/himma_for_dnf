package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.threadTest.TestService;
import com.goule666.himmaForDnf.threadTest.InsertBatchThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {
    @Resource
    private TestService testService;

    /**
     * 采用java1.5的Future特性手动创建10个线程
     * @throws Exception
     */
    @Test
    public void dailyVolume() throws Exception {
        Long start = System.currentTimeMillis();
        List<Future<Integer>> futureList = new ArrayList<>();
        //创建10个任务 master
        for (int i = 0; i < 5; i++) {
            Future<Integer> future = testService.insertBatchThread();
            futureList.add(future);
        }
        //.get是阻塞式，等待当前线程完成才返回值。
        for (Future<Integer> f : futureList) {
            System.out.println(f.get());
        }
        System.out.println(futureList.size());
        System.out.println("一共耗时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 手动创建10个线程
     * @throws Exception
     */
    @Test
    public void insertBatchThread() throws Exception {
        Long start = System.currentTimeMillis();
        //创建10个线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<>();
        //创建10个任务
        for (int i = 1; i <= 10; i++) {
            Future<Integer> future = executorService.submit(new InsertBatchThread(i));
            futureList.add(future);
        }
        //.get是阻塞式，等待当前线程完成才返回值。
        for (Future<Integer> f : futureList) {
            System.out.println(f.get());
        }
        System.out.println("一共耗时：" + (System.currentTimeMillis() - start));
    }

    /**
     * spring @Async测试
     * @throws InterruptedException
     */
    @Test
    public void testAsync() throws InterruptedException {
        testService.testAsync();
    }

    @Test
    public void testThread() throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        testService.saleTicket();
        System.out.println("卖1000张票，耗时：" + (System.currentTimeMillis() - start));
    }

}