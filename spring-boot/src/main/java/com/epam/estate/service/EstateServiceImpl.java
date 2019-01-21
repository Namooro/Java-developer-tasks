package com.epam.estate.service;

import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void view(Long id) {
        Estate estate = estateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid estate Id:" + id));
        estate.setViews(estate.getViews() + 1);
        estateRepository.save(estate);
    }

    @Override
    public void save(Estate estate) {
        estateRepository.save(estate);
    }
}
