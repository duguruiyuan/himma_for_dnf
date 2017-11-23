package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.HimmaTypeRepository;
import com.goule666.himmaForDnf.model.domain.HimmaTypeDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaTypeVO;
import com.goule666.himmaForDnf.service.DictService;
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
public class DictServiceImpl implements DictService {

    @Autowired
    private HimmaTypeRepository himmaTypeRepository;

    @Override
    public List<HimmaTypeVO> getHimmaTypeList() {
        List<HimmaTypeDO> himmaTypeDOList = himmaTypeRepository.findAll();
        List<HimmaTypeVO> resultList = new ArrayList<>();
        for(HimmaTypeDO w: himmaTypeDOList){
            HimmaTypeVO himmaTypeVO = new HimmaTypeVO();
            himmaTypeVO.setId(w.getId());
            himmaTypeVO.setName(w.getName());
            resultList.add(himmaTypeVO);
        }
        return resultList;
    }
}