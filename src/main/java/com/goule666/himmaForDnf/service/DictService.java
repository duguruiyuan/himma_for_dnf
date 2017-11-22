package com.goule666.himmaForDnf.service;

import com.alibaba.fastjson.JSONObject;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.domain.WorkerTypeDO;
import com.goule666.himmaForDnf.model.vo.WorkerTypeVO;

import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 14:00
 * @Description
 */
public interface DictService {
    /**
     * 获取所有的职业类型
     * @return
     */
    List<WorkerTypeVO> getWorkTypeList();

}