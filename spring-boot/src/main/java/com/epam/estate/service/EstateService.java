package com.epam.estate.service;

import com.epam.estate.model.Estate;

public interface EstateService {

    void view(Long id);

    void save(Estate estate);
}
