package com.epam.estate.service;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public List<Agent> getTopAgents(Date before, Date after) {
        Map<Agent, IntSummaryStatistics> agentsStat = estateRepository.findAll().stream().limit(5)
                .filter(estate ->
                        before.after(estate.getSell_date()) && after.before(estate.getSell_date()))
                .collect(Collectors.groupingBy(Estate::getAgent_id, Collectors.summarizingInt(Estate::getCost)));
        return agentsStat.entrySet().stream().sorted().limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Override
    public void view(Long id) {
        Estate estate = estateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid estate Id:" + id));
        estate.setViews(estate.getViews() + 1);
        estateRepository.save(estate);
    }

}
