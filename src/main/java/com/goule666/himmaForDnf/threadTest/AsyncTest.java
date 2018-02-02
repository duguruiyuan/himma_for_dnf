package com.goule666.himmaForDnf.threadTest;

import com.goule666.himmaForDnf.model.domain.MaterialDO;
import com.goule666.himmaForDnf.model.domain.UserDO;
import com.goule666.himmaForDnf.repository.MaterialRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author niewenlong
 * Date 2018/1/11 Time: 17:12
 * Description
 */
@Component
public class AsyncTest {

    private static Long ticket;

    private Integer tick = 600;

    @Autowired
    private MaterialRepository materialRepository;

    @Async
    public Future<Integer> test1() throws InterruptedException {
        System.out.println("线程1休息3秒");
        Thread.sleep(3000);
        System.out.println("线程1休息结束");
        return new AsyncResult<>(1);
    }
    @Async
    public Future<Integer> test2() throws InterruptedException {
        System.out.println("线程2休息3秒");
        Thread.sleep(3000);
        System.out.println("线程2休息结束");
        return new AsyncResult<>(2);
    }

    @Async
    public Future<Boolean> test3() throws InterruptedException {
            while (materialRepository.findOne(1).getPrice() > 0) {
                synchronized (materialRepository) {
                    MaterialDO materialDO = materialRepository.findOne(1);
                    if (materialDO.getPrice() > 0) {
                        materialDO.setPrice(materialDO.getPrice() - 1D);
                        materialRepository.save(materialDO);
                        System.out.println(Thread.currentThread().getName() + "卖出一张票" + "剩余" + materialDO.getPrice() + "票");
                    } else {
                        System.out.println("票卖完了");
                    }
                }
            }
            return new AsyncResult<>(true);
    }
    @Async
    public Future<Boolean> test4(){
        while (true) {
                if (tick > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=========" + tick--);
                } else {
                    break;
            }
        }
        return new AsyncResult<>(true);

    }

    @Async
    public Future<Integer> checkNameAndPassword(List<UserDO> userDOList) {
        Integer i = 0;
        for (UserDO u : userDOList) {
            if ("goule666".equals(u.getUserName()) && "goule666".equals(u.getPassword())) {
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return new AsyncResult<>(i);
    }

}