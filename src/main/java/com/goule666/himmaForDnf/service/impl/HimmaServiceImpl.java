package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.HimmaRepository;
import com.goule666.himmaForDnf.dao.WorkerRepository;
import com.goule666.himmaForDnf.dao.WorkerTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.domain.WorkerDO;
import com.goule666.himmaForDnf.model.domain.WorkerTypeDO;
import com.goule666.himmaForDnf.model.vo.WorkerVO;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 14:00
 * @Description
 */
@Service
public class HimmaServiceImpl implements HimmaService {

    @Autowired
    private HimmaRepository himmaRepository;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkerTypeRepository workerTypeRepository;
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<HimmaRecordDO> findAll() {
        return himmaRepository.findAll();
    }

    @Override
    public boolean creatWorker(String workerType,String workerName,String token) {
        Integer userId = userService.findByName(tokenUtils.getUsernameFromToken(token)).getId();
        WorkerDO workerDO = new WorkerDO();
        //默认可用
        workerDO.setStatus(1);
        //默认满疲劳
        workerDO.setSurplusPl(188);
        workerDO.setUserId(userId);
        workerDO.setWorkerName(workerName);
        workerDO.setWorkerTypeId(workerTypeRepository.findByCode(workerType).getId());
        workerRepository.save(workerDO);
        return true;
    }

    @Override
    public List<WorkerVO> getWorkerList() {
        WorkerVO workerVO = new WorkerVO();
        workerVO.setCreatedAt(new Date());
        workerVO.setStatus(1);
        workerVO.setSurplusPl(188);
        workerVO.setTimeUsed("20:00");
        workerVO.setTodayProfit(220D);
        workerVO.setWorkerType("BHLL");
        workerVO.setWorkerName("888x888x888");
        List<WorkerVO> workerVOList = new ArrayList<>();
        workerVOList.add(workerVO);
        return workerVOList;
    }

}