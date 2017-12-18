package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import com.goule666.himmaForDnf.repository.HimmaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HimmaServiceTest {
    @Resource
    private HimmaRecordRepository himmaRecordRepository;
    @Test
    public void creatWorker() throws Exception {
        HimmaRecordDO himmaRecordDO = new HimmaRecordDO();
        himmaRecordDO.setHimmaId(1);
        himmaRecordDO.setHimmaInfo("a");
        himmaRecordDO.setProfit(1D);
        himmaRecordDO.setTimeUsed("a");
        himmaRecordDO.setStartTime(new Date());
        himmaRecordDO.setEndTime(new Date());
        himmaRecordRepository.save(himmaRecordDO);
    }

}