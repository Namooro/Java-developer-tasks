package com.epam.estate.repository;

import com.epam.estate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EstateRepository extends JpaRepository<Estate, Integer> {

    String TOP_AGENTS_BY_MONTH_SOLD_ESTATES_QUERY = "Select names from( SELECT a.id, a.name as names, SUM(e.cost) as month_total_price " +
            "FROM agent a " +
            "INNER JOIN estate e ON e.agent_id=a.id " +
            "WHERE e.sell_date >:dateFrom AND e.sell_date < :dateTo " +
            "GROUP BY a.id " +
            "ORDER BY month_total_price DESC " +
            "LIMIT 5)";


    @Query(value = TOP_AGENTS_BY_MONTH_SOLD_ESTATES_QUERY, nativeQuery = true)
    List<String> topFive(@Param("dateFrom") Date before, @Param("dateTo") Date after);
}
