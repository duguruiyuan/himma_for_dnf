package com.goule666.himmaForDnf.service.impl;

import com.goule666.himmaForDnf.dao.HimmaRepository;
import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import com.goule666.himmaForDnf.service.HimmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niewenlong
 * @Date 2017/11/10 Time: 14:00
 * @Description
 */
@Service
public class HimmaServiceImpl implements HimmaService {

    @Autowired
    private HimmaRepository himmaRepository;
    @Override
    public List<HimmaRecordDO> findAll() {
        return himmaRepository.findAll();
    }
}