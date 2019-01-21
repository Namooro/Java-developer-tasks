package com.epam.estate.repository;

import com.epam.estate.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
    Agent findByName(String name);
}

