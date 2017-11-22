package com.goule666.himmaForDnf.dao;

import com.goule666.himmaForDnf.model.domain.WorkerDO;
import com.goule666.himmaForDnf.model.domain.WorkerTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface WorkerRepository extends JpaRepository<WorkerDO, Integer> {


}
