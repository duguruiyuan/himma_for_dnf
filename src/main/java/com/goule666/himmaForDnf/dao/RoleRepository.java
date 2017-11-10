package com.goule666.himmaForDnf.dao;

import com.goule666.himmaForDnf.model.domain.RoleDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface RoleRepository extends JpaRepository<RoleDO, Integer> {
    /**
     * 根据role_id查询roleDO
     * @param id
     * @return
     */
    RoleDO findById(Integer id);


}
