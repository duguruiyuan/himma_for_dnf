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
     * @param typeId 搬砖工人类型id
     * @param name 搬砖名称
     * @param token token
     * @return true or false
     */
    boolean creatWorker(Integer typeId,String name,String token);

    /**
     * 获取所有工人列表
     * @return 所有工人列表
     */
    List<HimmaVO> getWorkerList(String token);
}