package com.epam.estate.controller;

import com.epam.estate.model.Agent;
import com.epam.estate.repository.AgentRepository;
import com.epam.estate.service.AgentService;
import com.epam.estate.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentService agentService;

    @Autowired
    EstateService estateService;

    @PostMapping("/add_agent")
    public String addAgent(Agent agent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-agent";
        }
        agentRepository.save(agent);
        model.addAttribute("agents", agentRepository.findAll());
        return "index";
    }

    @GetMapping("/edit_agent/{id}")
    public String updateAgent(@PathVariable("id") int id, Model model) {
        Agent agent = agentRepository.findById(id)
                .get();
        model.addAttribute("agent", agent);
        return "update_agent";
    }

    @PostMapping("/update_agent/{id}")
    public String updateAgent(@PathVariable("id") int id, Agent agent,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            agent.setId(id);
            return "update_agent";
        }

        agentRepository.save(agent);
        model.addAttribute("agent", agentRepository.findAll());
        return "index";
    }

    @GetMapping("/delete_agent/{id}")
    public String deleteAgent(@PathVariable("id") int id, Model model) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + id));
        agentRepository.delete(agent);
        model.addAttribute("agent", agentRepository.findAll());
        return "index";
    }

    @PostMapping("/agentRating")
    public List<String> topFiveAgents(Model model, Date from, Date to) {
        List<String> topAgentsNames = estateService.getTopAgents(from, to);
        model.addAttribute("agentsRating", topAgentsNames);
        return topAgentsNames;
    }

    @GetMapping("view_sales/{id}")
    public String viewAgent(@PathVariable("id") int id, Model model) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + id));
        return agent.getEstateList().toString();
    }
}
