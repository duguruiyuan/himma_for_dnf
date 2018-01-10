package com.goule666.himmaForDnf.repository;

import com.goule666.himmaForDnf.model.domain.HimmaTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface HimmaTypeRepository extends JpaRepository<HimmaTypeDO, Integer> {

}
