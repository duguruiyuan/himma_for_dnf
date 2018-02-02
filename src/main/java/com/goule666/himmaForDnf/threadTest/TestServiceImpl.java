package com.goule666.himmaForDnf.threadTest;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.domain.MaterialDO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import com.goule666.himmaForDnf.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author niewenlong
 * Date 2017/12/20 Time: 9:16
 * Description
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource
    private HimmaRecordRepository himmaRecordRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private AsyncTest asyncTest;

    @Async
    @Override
    public Future<Integer> insertBatchThread() throws InterruptedException {
        List<HimmaRecordDO> himmaRecordDOList = new ArrayList<>();
        for (int j = 0; j < 1000000; j++) {
            HimmaRecordDO himmaRecordDO = new HimmaRecordDO();
            himmaRecordDO.setStartTime(new Date());
            himmaRecordDO.setEndTime(new Date());
            int a = j % 4;
            switch (a) {
                case 0:
                    himmaRecordDO.setHimmaId(1);
                    break;
                case 1:
                    himmaRecordDO.setHimmaId(2);
                    break;
                case 2:
                    himmaRecordDO.setHimmaId(3);
                    break;
                case 3:
                    himmaRecordDO.setHimmaId(4);
                default:
                    break;
            }
            himmaRecordDO.setHimmaInfo("a");
            himmaRecordDO.setProfit(1D);
            himmaRecordDO.setTimeUsed("b");
            himmaRecordDOList.add(himmaRecordDO);
        }
        himmaRecordRepository.save(himmaRecordDOList);
        return new AsyncResult<>(1);
    }

    @Override
    public void testAsync() throws InterruptedException {
        Long start = System.currentTimeMillis();
        Future<Integer> aThread = asyncTest.test1();
        Future<Integer> bThread = asyncTest.test2();
        Future<Integer> cThread = asyncTest.test1();
        Future<Integer> dThread = asyncTest.test1();
        Future<Integer> eThread = asyncTest.test1();
        while (true) {
            if (aThread.isDone() && bThread.isDone() && cThread.isDone() && dThread.isDone() && eThread.isDone()) {
                break;
            }
        }
        System.out.println("一共耗时" + (System.currentTimeMillis() - start));
    }


    @Override
    public void saleTicket() throws InterruptedException{
        Future<Boolean> aThread = asyncTest.test4();
        Future<Boolean> bThread = asyncTest.test4();
        Future<Boolean> cThread = asyncTest.test4();
        Future<Boolean> dThread = asyncTest.test4();
        while (true) {
            if (aThread.isDone() && bThread.isDone() && cThread.isDone() && dThread.isDone()) {
                break;
            }
        }
    }


}