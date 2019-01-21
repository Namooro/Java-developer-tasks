package com.epam.estate;

import com.epam.estate.model.Agent;
import com.epam.estate.model.Estate;
import com.epam.estate.repository.AgentRepository;
import com.epam.estate.repository.EstateRepository;
import com.epam.estate.service.AgentService;
import com.epam.estate.service.EstateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EstatesTest {
    @Autowired
    EstateService estateService;

    EstateRepository estateRepository;
    @Autowired
    AgentService agentService;

    AgentRepository agentRepository;

    private Long firstID = 1L;

    @Test
    public void findEstate() {
        Estate estate = new Estate();
    }

    @Test
    public void findAgent() {
        Agent agent = new Agent(firstID, "123");
        assertEquals(agent.getName(), agentService.getAgents());
    }
}
