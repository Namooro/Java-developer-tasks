package com.epam.estate.service;

import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public Set<Integer> getTopAgents(Date before, Date after) {
        return estateRepository.topFive(before, after).entrySet().stream().map(e->e.getKey()).collect(Collectors.toSet());
    }

    @Override
    public void view(Integer id) {
        Estate estate = estateRepository.findById(id).get();
        estate.setViews(estate.getViews() + 1);
        estateRepository.save(estate);
    }

}
