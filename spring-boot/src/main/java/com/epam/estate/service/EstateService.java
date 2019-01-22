package com.epam.estate.service;

import com.epam.estate.model.Agent;

import java.util.Date;
import java.util.List;

public interface EstateService {
    List<Agent> getTopAgents(Date before, Date after);

    void view(Long id);
}
