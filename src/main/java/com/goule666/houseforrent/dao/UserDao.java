package com.goule666.houseforrent.dao;

import com.goule666.houseforrent.model.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    int insert(@Param("pojo") UserDO pojo);

    /**
     * 根据用户名查询userDO
     * @param name
     * @return
     */
    UserDO findByName(@Param("name")String name);


}
