package com.epam.estate.service;

import java.util.Date;
import java.util.List;

public interface EstateService {
    List<String> getTopAgents(Date before, Date after);

    void view(Integer id);
}
