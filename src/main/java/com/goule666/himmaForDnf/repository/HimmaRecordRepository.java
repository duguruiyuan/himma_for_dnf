package com.goule666.himmaForDnf.repository;

import com.goule666.himmaForDnf.model.domain.HimmaRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * @author niewenlong
 */
@Component
public interface HimmaRecordRepository extends JpaRepository<HimmaRecordDO, Integer> {


    @Query(value = "select * from himma_record where to_days(updated_at) = to_days(now()) and himma_id=?1",nativeQuery = true)
    HimmaRecordDO findTodayHimmaRecordDOByHimmaId(Integer himmaId);
}
