package com.goule666.himmaForDnf.web;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author niewenlong
 * Date 2017/12/19 Time: 14:45
 * Description
 */
@Component
public class InsertBatchThread implements Callable<Integer> {
    @Resource
    private HimmaRecordRepository himmaRecordRepository;
    private Integer i;

    public InsertBatchThread() {
    }

    public InsertBatchThread(Integer i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "线程被调用" + i);
        return 1;
    }
}