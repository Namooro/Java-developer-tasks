package com.epam.estate.service;

import com.epam.estate.model.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAgents();

    Integer agentResult(Integer id);

}
