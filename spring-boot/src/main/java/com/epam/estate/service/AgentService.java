package com.epam.estate.service;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;

import java.util.List;

public interface AgentService {
    List<Agent> getAgents();

    List<Estate> getEstates(Agent agent);
}
