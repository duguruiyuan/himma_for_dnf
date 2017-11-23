package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.HimmaRecordRepository;
import com.goule666.himmaForDnf.dao.HimmaRepository;
import com.goule666.himmaForDnf.dao.HimmaTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaDO;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
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
    private HimmaRecordRepository himmaRecordRepository;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private HimmaTypeRepository himmaTypeRepository;
    @Autowired
    private HimmaRepository himmaRepository;

    @Override
    public List<HimmaRecordDO> findAll() {
        return himmaRecordRepository.findAll();
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
        himmaRepository.save(himmaDO);
        return true;
    }

    @Override
    public List<HimmaVO> getWorkerList(String token) {
        Integer userId = userService.findByName(tokenUtils.getUsernameFromToken(token)).getId();
        HimmaVO himmaVO = new HimmaVO();
        himmaVO.setCreatedAt(new Date());
        himmaVO.setStatus(1);
        himmaVO.setSurplusPl(188);
        himmaVO.setTimeUsed("20:00");
        himmaVO.setTodayProfit(220D);
        himmaVO.setType("狱血魔神");
        himmaVO.setName("888x888x888");
        List<HimmaVO> himmaVOList = new ArrayList<>();
        himmaVOList.add(himmaVO);
        return himmaVOList;
    }

}