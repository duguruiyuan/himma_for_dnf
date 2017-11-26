package com.goule666.himmaForDnf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.domain.MaterialPriceDO;
import com.goule666.himmaForDnf.repository.HimmaRecordRepository;
import com.goule666.himmaForDnf.repository.HimmaRepository;
import com.goule666.himmaForDnf.repository.HimmaTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaDO;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.repository.MaterialPriceRepository;
import com.goule666.himmaForDnf.service.HimmaService;
import com.goule666.himmaForDnf.service.UserService;
import com.goule666.himmaForDnf.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private MaterialPriceRepository materialPriceRepository;

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
        List<HimmaVO> himmaVOList = new ArrayList<>();
        Integer userId = userService.findByName(tokenUtils.getUsernameFromToken(token)).getId();
        List<HimmaDO> himmaDOList = himmaRepository.findHimmaDOByUserId(userId);
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
        himmaRecordRepository.save(himmaRecordDO);
        return true;
    }

    @Override
    public Boolean endHimma(String himmaInfo, Integer himmaId) {
        //todo 需要重新做
        HimmaRecordDO himmaRecordDO = himmaRecordRepository.findTodayHimmaRecordDOByHimmaId(himmaId);
        //搬砖结束时间
        himmaRecordDO.setEndTime(new Date());
        //搬砖详细信息
        himmaRecordDO.setHimmaInfo(himmaInfo);
        //耗时
        himmaRecordDO.setTimeUsed(String.valueOf(System.currentTimeMillis() - himmaRecordDO.getStartTime().getTime()));
        //解析{"mssCount":0,"tzsCount":0,"wsCount":0,"ywsh":0,"jb":0}
        JSONObject json = JSON.parseObject(himmaInfo);
        //计算收益 mss+tzs+ws+ywys+ywsh+jb
        BigDecimal mssPrice = new BigDecimal(0);
        BigDecimal tzsPrice = new BigDecimal(0);
        BigDecimal wsPrice = new BigDecimal(0);
        BigDecimal ywysPrice = new BigDecimal(0);
        Double todayProfit = 0D;
        List<MaterialPriceDO> materialPriceDOList = materialPriceRepository.findAll();
        for(MaterialPriceDO m:materialPriceDOList){
            if(m.getId() == 1){
                mssPrice = BigDecimal.valueOf(m.getPrice());
            }
            if(m.getId() == 2){
                tzsPrice = BigDecimal.valueOf(m.getPrice());
            }
            if(m.getId() == 3){
                wsPrice = BigDecimal.valueOf(m.getPrice());
            }
            if(m.getId() == 4){
                ywysPrice = BigDecimal.valueOf(m.getPrice());
            }
        }
        todayProfit = mssPrice.multiply(json.getBigDecimal("mssCount")).doubleValue() + tzsPrice.multiply(json.getBigDecimal("tzsCount")).doubleValue() +
                wsPrice.multiply(json.getBigDecimal("wsCount")).doubleValue() + ywysPrice.multiply(json.getBigDecimal("ywys")).doubleValue();
        himmaRecordDO.setProfit(todayProfit);
        himmaRecordRepository.save(himmaRecordDO);
        return true;
    }

}