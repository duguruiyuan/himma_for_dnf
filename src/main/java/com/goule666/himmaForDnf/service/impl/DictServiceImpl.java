package com.goule666.himmaForDnf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.dao.WorkerTypeRepository;
import com.goule666.himmaForDnf.model.domain.WorkerTypeDO;
import com.goule666.himmaForDnf.model.vo.WorkerTypeVO;
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
    private WorkerTypeRepository workerTypeRepository;

    @Override
    public List<WorkerTypeVO> getWorkTypeList() {
        List<WorkerTypeDO> workerTypeDOList = workerTypeRepository.findAll();
        List<WorkerTypeVO> resultList = new ArrayList<>();
        for(WorkerTypeDO w:workerTypeDOList){
            WorkerTypeVO workerTypeVO = new WorkerTypeVO();
            workerTypeVO.setCode(w.getCode());
            workerTypeVO.setName(w.getName());
            resultList.add(workerTypeVO);
        }
        return resultList;
    }
}