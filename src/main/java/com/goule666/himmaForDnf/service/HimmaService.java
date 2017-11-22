package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.domain.WorkerDO;
import com.goule666.himmaForDnf.model.domain.WorkerTypeDO;
import com.goule666.himmaForDnf.model.vo.WorkerVO;

import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 14:00
 * @Description
 */
public interface HimmaService {
    List<HimmaRecordDO> findAll();

    /**
     * 创建工人
     * @param workerType
     * @param workerName
     * @param token
     * @return
     */
    boolean creatWorker(String workerType,String workerName,String token);

    /**
     * 获取所有工人列表
     * @return
     */
    List<WorkerVO> getWorkerList();
}