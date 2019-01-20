package com.epam.estate.controllers;

import com.epam.estate.beans.Agent;
import com.epam.estate.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class AgentController {
    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Agent agent) {
        return "add-agent";
    }

    @PostMapping("/add-agent")
    public String addAgent(@Valid Agent agent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-agent";
        }
        agentRepository.save(agent);
        model.addAttribute("agents", agentRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String updateAgent(@PathVariable("id") long id, Model model) {
        Agent user = agentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + id));
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateAgent(@PathVariable("id") long id, @Valid Agent agent,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            agent.setId(id);
            return "update-uAgent";
        }

        agentRepository.save(agent);
        model.addAttribute("agents", agentRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteAgent(@PathVariable("id") long id, Model model) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + id));
        agentRepository.delete(agent);
        model.addAttribute("agents", agentRepository.findAll());
        return "index";
    }
}
