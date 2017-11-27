package com.goule666.himmaForDnf.repository;

import com.goule666.himmaForDnf.model.domain.HimmaDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author niewenlong
 */
@Component
public interface HimmaRepository extends JpaRepository<HimmaDO, Integer> {

    /**
     * 查询当前用户下的所有搬砖工人
     * @param userId 用户id
     * @return 搬砖工人集合
     */
    List<HimmaDO> findByUserIdOrderBySurplusPlDesc(@Param("userId") Integer userId);

    /**
     * 根据姓名查询搬砖人员信息
     * @param name
     * @return
     */
    HimmaDO findByName(@Param("name") String name);

}
