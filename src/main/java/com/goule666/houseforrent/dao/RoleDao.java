package com.goule666.houseforrent.dao;

import com.goule666.houseforrent.model.domain.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleDao {
    int insert(@Param("pojo") RoleDO pojo);

    /**
     * 根据role_id查询roleDO
     * @param id
     * @return
     */
    RoleDO findById(@Param("id")Integer id);



}
