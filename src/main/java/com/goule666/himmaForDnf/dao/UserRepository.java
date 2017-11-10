package com.goule666.himmaForDnf.dao;

import com.goule666.himmaForDnf.model.domain.UserDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface UserRepository extends JpaRepository<UserDO, Integer> {

    UserDO findByUserName(String userName);


}
