package com.goule666.himmaForDnf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.domain.MaterialDO;
import com.goule666.himmaForDnf.model.vo.himma.MaterialVO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import com.goule666.himmaForDnf.repository.HimmaRepository;
import com.goule666.himmaForDnf.repository.HimmaTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaDO;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.repository.MaterialRepository;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

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
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<HimmaRecordDO> findAll() {
        return (List<HimmaRecordDO>)himmaRecordRepository.findAll();
    }

    @Override
    public boolean creatWorker(Integer typeId, String name, String token) {
        if (himmaRepository.findByName(name) != null) {
            return false;
        }
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
        List<HimmaVO> himmaVOList = new ArrayList<>();
        Integer userId = userService.findByName(tokenUtils.getUsernameFromToken(token)).getId();
        List<HimmaDO> himmaDOList = himmaRepository.findByUserIdOrderBySurplusPlDesc(userId);
        for (HimmaDO h : himmaDOList) {
            HimmaRecordDO himmaRecordDO = himmaRecordRepository.findTodayHimmaRecordDOByHimmaId(h.getId());
            HimmaVO himmaVO = new HimmaVO();
            himmaVO.setId(h.getId());
            himmaVO.setCreatedAt(h.getCreatedAt());
            himmaVO.setStatus(h.getStatus());
            himmaVO.setSurplusPl(h.getSurplusPl());
            himmaVO.setType(himmaTypeRepository.findOne(h.getTypeId()).getName());
            himmaVO.setName(h.getName());
            if (himmaRecordDO != null) {
                himmaVO.setTimeUsed(himmaRecordDO.getTimeUsed());
                himmaVO.setTodayProfit(himmaRecordDO.getProfit());
            }
            himmaVOList.add(himmaVO);
        }
        return himmaVOList;
    }

    @Override
    public Boolean startHimma(Integer himmaId) {
        HimmaRecordDO himmaRecordDO = new HimmaRecordDO();
        //搬砖工人id
        himmaRecordDO.setHimmaId(himmaId);
        //搬砖开始时间
        himmaRecordDO.setStartTime(new Date());
        //判断当前工人当天是否创建 如果创建则更新
        HimmaRecordDO himmaRecordDO1 = himmaRecordRepository.findTodayHimmaRecordDOByHimmaId(himmaId);
        if (himmaRecordDO1 != null) {
            //设置id 更新
            himmaRecordDO.setId(himmaRecordDO1.getId());
        }
        himmaRecordRepository.save(himmaRecordDO);
        return true;
    }

    @Override
    public Double endHimma(String himmaInfo, Integer himmaId) {
        HimmaRecordDO himmaRecordDO = himmaRecordRepository.findTodayHimmaRecordDOByHimmaId(himmaId);
        //搬砖结束时间
        himmaRecordDO.setEndTime(new Date());
        //搬砖详细信息
        himmaRecordDO.setHimmaInfo(himmaInfo);
        //耗时
        himmaRecordDO.setTimeUsed(String.valueOf(System.currentTimeMillis() - himmaRecordDO.getStartTime().getTime()));

        JSONObject json = JSON.parseObject(himmaInfo);
        //解析[{"materialId":1,"startValue":"0","endValue":"500"},{"materialId":2,"startValue":0,"endValue":"5000"},{"materialId":3,"startValue":0,"endValue":"600"},{"materialId":4,"startValue":0,"endValue":"8"}]
        List<JSONObject> jsonArray = JSON.parseArray(json.getString("materialItems"), JSONObject.class);
        //计算收益 mss+tzs+ws+ywys+windfall+money
        Double todayProfit = 0D;
        //意外收获
         Double windfall = json.getDouble("windfall");
        //金币收益
        Double moneyProfit = json.getDouble("endMoney") - json.getDouble("startMoney");
        for (JSONObject j : jsonArray) {
            todayProfit += (j.getDouble("endValue") - j.getDouble("startValue")) * materialRepository.findOne(j.getInteger("materialId")).getPrice();
        }
        himmaRecordDO.setProfit(todayProfit + moneyProfit + windfall);
        HimmaDO himmaDO = himmaRepository.findOne(himmaId);
        //默认疲劳值为0
        himmaDO.setSurplusPl(0);
        himmaRecordRepository.save(himmaRecordDO);
        return todayProfit + moneyProfit + windfall;
    }

    @Override
    public List<MaterialVO> getMaterialInfo() {
        List<MaterialDO> materialDOList = materialRepository.findAll();
        List<MaterialVO> materialVOList = new ArrayList<>();
        for (MaterialDO m : materialDOList) {
            MaterialVO materialVO = new MaterialVO();
            materialVO.setId(m.getId());
            materialVO.setName(m.getName());
            materialVO.setPrice(m.getPrice());
            materialVOList.add(materialVO);
        }
        return materialVOList;
    }

    @Override
    public Boolean changeMaterialPrice(List<MaterialVO> materialVOList) {
        for (MaterialVO m : materialVOList) {
            MaterialDO materialDO = materialRepository.findOne(m.getId());
            materialDO.setPrice(m.getPrice());
            materialRepository.save(materialDO);
        }
        return true;
    }

}