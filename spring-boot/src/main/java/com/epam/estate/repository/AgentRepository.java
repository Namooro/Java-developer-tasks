package com.epam.estate.repository;

import com.epam.estate.beans.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {

}

