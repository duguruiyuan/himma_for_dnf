package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import com.goule666.himmaForDnf.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author niewenlong
 * Date 2017/12/20 Time: 9:16
 * Description
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private HimmaRecordRepository himmaRecordRepository;
    @Async
    @Override
    public Future<Integer> insertBatchThread() throws InterruptedException {
        for (int i = 1; i < 1000; i++) {
            List<HimmaRecordDO> himmaRecordDOList = new ArrayList<>();
            for (int j = 1; j < 100; j++) {
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
        }
        return new AsyncResult<>(1);
    }
}