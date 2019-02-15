package com.epam.estate;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;
import com.epam.estate.repository.AgentRepository;
import com.epam.estate.repository.EstateRepository;
import com.epam.estate.service.AgentService;
import com.epam.estate.service.EstateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EstatesTest {

    Logger logger = LoggerFactory.getLogger(EstatesTest.class);

    @Autowired
    AgentService agentService;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    EstateService estateService;
    @Autowired
    EstateRepository estateRepository;

    private Integer FIRST_ID = 1;
    private Integer SECOND_ID = 2;
    private Integer THIRD_ID = 3;

    private String FIRST_NAME = "first";
    private String SECOND_NAME = "second";
    private String THIRD_NAME = "third";

    @Before
    public void before() {
        List<Agent> agents = new ArrayList<>();
        Agent firstAgent = new Agent(FIRST_ID, FIRST_NAME);
        Agent secondAgent = new Agent(SECOND_ID, SECOND_NAME);
        Agent thirdAgent = new Agent(THIRD_ID, THIRD_NAME);
        agents.add(firstAgent);
        agents.add(secondAgent);
        agents.add(thirdAgent);
        agentRepository.saveAll(agents);
        List<Estate> estates = new ArrayList<>();
        estates.add(new Estate(9, "Saint-Petersburg", 32, Date.valueOf("2018-04-01"), 0, thirdAgent));
        estates.add(new Estate(8, "Saint-Petersburg", 32, Date.valueOf("2018-04-01"), 0, secondAgent));
        estates.add(new Estate(7, "Saint-Petersburg", 32, Date.valueOf("2018-04-01"), 0, thirdAgent));
        estates.add(new Estate(6, "Moscow", 32, Date.valueOf("2018-04-01"), 0, thirdAgent));
        estates.add(new Estate(5, "Togliatty", 32, Date.valueOf("2018-03-01"), 0, secondAgent));
        estates.add(new Estate(4, "Samara", 32, Date.valueOf("2018-02-01"), 0, secondAgent));
        estates.add(new Estate(3, "Togliatty", 32, Date.valueOf("2018-01-02"), 0, firstAgent));
        estates.add(new Estate(2, "Togliatty", 32, Date.valueOf("2018-01-02"), 0, firstAgent));
        estates.add(new Estate(1, "Togliatty", 32, Date.valueOf("2018-01-01"), 0, firstAgent));
        estateRepository.saveAll(estates);
    }

    @Test
    public void findUniqueAgents() {
        assertEquals(Arrays.asList(FIRST_ID, SECOND_ID, THIRD_ID), agentRepository.findAll().stream().map(Agent::getId).collect(Collectors.toList()));
    }

    @Test
    public void checkView() {
        estateService.view(1);
        assertEquals(1,
                (int) estateRepository.findById(1).get().getViews());
    }

    @Test
    public void checkTopFive() {
        assertEquals(Arrays.asList(FIRST_NAME, SECOND_NAME), estateService.getTopAgents(Date.valueOf("2018-01-01"), Date.valueOf(("2018-03-01"))));
    }

}
