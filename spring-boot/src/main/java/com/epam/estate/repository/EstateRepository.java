package com.epam.estate.repository;

import com.epam.estate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Map;

public interface EstateRepository extends JpaRepository<Estate, Integer> {

    @Query(value = "SELECT agent_id, sum(cost) FROM Estate where sell_date >:before and sell_date <:after group by agent_id, sell_Date limit 5", nativeQuery = true)
    Map<Integer, Integer> topFive(@Param("before") Date before, @Param("after") Date after);
}
