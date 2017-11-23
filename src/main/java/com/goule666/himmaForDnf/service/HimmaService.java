package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;

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
     * @param typeId
     * @param name
     * @param token
     * @return
     */
    boolean creatWorker(Integer typeId,String name,String token);

    /**
     * 获取所有工人列表
     * @return
     */
    List<HimmaVO> getWorkerList();
}