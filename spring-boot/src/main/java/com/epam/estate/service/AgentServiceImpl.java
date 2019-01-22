package com.epam.estate.service;

import com.epam.estate.model.Agent;
import com.epam.estate.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }

}
