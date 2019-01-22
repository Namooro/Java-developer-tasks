package com.epam.estate.service;

import com.epam.estate.model.Agent;

import java.util.Date;

public interface EstateService {
    Agent getTop(Date before, Date after);

    void view(Long id);
}
