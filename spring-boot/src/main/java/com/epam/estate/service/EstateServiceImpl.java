package com.epam.estate.service;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Override
    public Agent getTop(Date before, Date after) {
        Map<Agent, Long> agentsMap = estateRepository.findAll().stream().limit(5)
                .filter(estate ->
                        before.after(estate.getSell_date()) && after.before(estate.getSell_date()))
                .map(Estate::getAgent_id)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Map.Entry<Agent, Long>> maxEntry = agentsMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get()
                .getKey();
    }

    @Override
    public void view(Long id) {
        Estate estate = estateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid estate Id:" + id));
        estate.setViews(estate.getViews() + 1);
        estateRepository.save(estate);
    }

}
