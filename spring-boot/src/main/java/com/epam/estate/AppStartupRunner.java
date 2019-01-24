package com.epam.estate;

import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Order(1)
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) {
        logger.info("Your application started with option names : {}", args.getOptionNames().isEmpty() ? "No arguments" : args.getOptionNames());
    }

    @Scheduled(fixedRate = 1000)
    public void realTimePriceChanges() {
        Integer percent = ThreadLocalRandom.current().nextInt(1, 100);
        List<Estate> estates = estateRepository.findAll();
        estates.forEach(estate -> estate.setCost(estate.getCost() * percent / 10));
        estateRepository.saveAll(estates);

        logger.info("Prices for estates were changed for {} percents", percent/10);
    }
}
