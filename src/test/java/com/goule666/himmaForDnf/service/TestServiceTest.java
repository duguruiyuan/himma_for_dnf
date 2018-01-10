package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.web.InsertBatchThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {
    @Resource
    private TestService testService;
    @Test
    public void dailyVolume() throws Exception {
        Long start = System.currentTimeMillis();
        List<Future<Integer>> futureList = new ArrayList<>();
        //创建10个任务
        for (int i = 0; i < 10; i++) {
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

}