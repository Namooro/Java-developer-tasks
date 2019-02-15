package com.epam.estate.service;

import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public List<String> getTopAgents(Date before, Date after) {
        return new ArrayList<>(estateRepository.topFive(before, after));
    }

    @Override
    public void view(Integer id) {
        Estate estate = estateRepository.findById(id).get();
        estate.setViews(estate.getViews() + 1);
        estateRepository.save(estate);
    }

}
