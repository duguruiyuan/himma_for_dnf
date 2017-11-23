package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.HimmaRepository;
import com.goule666.himmaForDnf.dao.WorkerRepository;
import com.goule666.himmaForDnf.dao.WorkerTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaDO;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean creatWorker(Integer typeId,String name,String token) {
        Integer userId = userService.findByName(tokenUtils.getUsernameFromToken(token)).getId();
        HimmaDO himmaDO = new HimmaDO();
        //默认可用
        himmaDO.setStatus(1);
        //默认满疲劳
        himmaDO.setSurplusPl(188);
        himmaDO.setUserId(userId);
        himmaDO.setName(name);
        himmaDO.setTypeId(typeId);
        workerRepository.save(himmaDO);
        return true;
    }

    @Override
    public List<HimmaVO> getWorkerList() {
        HimmaVO himmaVO = new HimmaVO();
        /*himmaVO.setCreatedAt(new Date());
        himmaVO.setStatus(1);
        himmaVO.setSurplusPl(188);
        himmaVO.setTimeUsed("20:00");
        himmaVO.setTodayProfit(220D);
        himmaVO.setWorkerType("BHLL");
        himmaVO.setWorkerName("888x888x888");*/
        List<HimmaVO> himmaVOList = new ArrayList<>();
        himmaVOList.add(himmaVO);
        return himmaVOList;
    }

}