package com.goule666.himmaForDnf.repository;

import com.goule666.himmaForDnf.model.domain.PriceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface PriceRepository extends JpaRepository<PriceDO, Integer> {


}
