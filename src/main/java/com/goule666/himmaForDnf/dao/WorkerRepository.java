package com.goule666.himmaForDnf.dao;

import com.goule666.himmaForDnf.model.domain.HimmaDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface WorkerRepository extends JpaRepository<HimmaDO, Integer> {


}
