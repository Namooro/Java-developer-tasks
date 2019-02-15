package com.epam.estate;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;
import com.epam.estate.repository.AgentRepository;
import com.epam.estate.repository.EstateRepository;
import com.epam.estate.service.AgentService;
import com.epam.estate.service.EstateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AgentsTest {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    EstateService estateService;

    @Autowired
    EstateRepository estateRepository;

    private Integer FIRST_ID = 1;

    private String FIRST_NAME = "first";

    @Before
    public void before() {
        Agent firstAgent = new Agent(FIRST_ID, FIRST_NAME);
        agentRepository.save(firstAgent);
        List<Estate> estates = new ArrayList<>();
        estates.add(new Estate(2, "Togliatty", 32, Date.valueOf("2018-01-02"), 0, firstAgent));
        estates.add(new Estate(1, "Togliatty", 32, Date.valueOf("2018-01-01"), 0, firstAgent));
        estateRepository.saveAll(estates);

    }

    @After
    public void after() {
        agentRepository.deleteAll();
    }

    @Test
    public void findAgent() {
        assertEquals(FIRST_NAME, agentRepository.findById(FIRST_ID).get().getName());
    }

    @Test
    public void testAgentSum() {
        assertEquals(64, agentRepository.soldProperty(FIRST_ID).intValue());
    }
}
