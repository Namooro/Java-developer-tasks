package com.epam.estate.service;

import java.util.Date;
import java.util.Set;

public interface EstateService {
    Set<Integer> getTopAgents(Date before, Date after);

    void view(Integer id);
}
