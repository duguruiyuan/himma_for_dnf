package com.goule666.himmaForDnf.service;

import com.goule666.himmaForDnf.model.vo.himma.HimmaTypeVO;

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
    List<HimmaTypeVO> getHimmaTypeList();

}