package com.epam.estate.repository;

import com.epam.estate.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

    @Query("select sum(cost) from Estate e where e.agent.id = :agentID")
    Integer soldProperty(@Param("agentID") Integer agentId);
}

