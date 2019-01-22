package com.epam.estate;

import com.epam.estate.model.Agent;
import com.epam.estate.repository.AgentRepository;
import com.epam.estate.service.AgentService;
import org.junit.After;
import org.junit.Before;
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
public class AgentsTest {

    @Autowired
    AgentService agentService;
    @Autowired
    AgentRepository agentRepository;

    private Integer FIRST_ID = 1;

    @Before
    public void before() {
        agentRepository.deleteAll();
        Agent agent = new Agent(1, "123");
        agentRepository.save(agent);
    }

    @After
    public void after() {
        agentRepository.deleteAll();
    }

    @Test
    public void findAgent() {
        Agent agent = new Agent(FIRST_ID, "123");
        assertEquals(agent.getName(), agentRepository.findById(FIRST_ID)
                .orElse(null).getName());
    }
}
