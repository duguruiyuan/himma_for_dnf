package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.model.vo.himma.HimmaVO;
import com.goule666.himmaForDnf.model.vo.himma.MaterialVO;

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

    /**
     * 开始搬砖
     * @param himmaId 工人id
     * @return 是否成功
     */
    Boolean startHimma(Integer himmaId);

    /**
     * 结束搬砖
     * @param himmaInfo 搬砖信息
     * @param himmaId 工人id
     * @return 收益
     */
    Double endHimma(String himmaInfo,Integer himmaId);

    /**
     * 获取下拉框内容(搬砖材料)
     */
    List<MaterialVO> getMaterialInfo();

    /**
     * 修改材料价格
     * @param materialVOList 材料VO
     * @return true or false
     */
    Boolean changeMaterialPrice(List<MaterialVO> materialVOList);
}