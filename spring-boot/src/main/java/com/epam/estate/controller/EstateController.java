package com.epam.estate.controller;

import com.epam.estate.model.Estate;
import com.epam.estate.repository.EstateRepository;
import com.epam.estate.service.EstateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EstateController {

    @Autowired
    private EstateService estateService;
    @Autowired
    private EstateRepository estateRepository;

    Logger logger = LoggerFactory.getLogger(EstateController.class);

    @RequestMapping(value = "/view_estates/{id}", method = RequestMethod.POST)
    public String viewEstates(@PathVariable int id) {
        estateService.view(id);
        return "OK";
    }

    @GetMapping("/estates")
    public List<Estate> retrieweAllEstates() {
        return estateRepository.findAll();
    }

    @GetMapping("/estates/{id}")
    public Estate retrieveEstate(@PathVariable int id) {
        Optional<Estate> estate = estateRepository.findById(id);
        return estate.get();
    }

    @GetMapping("estates/top")
    public List<String> retrieveAgentNames(Date before, Date after) {
        return estateService.getTopAgents(before, after);
    }

    @DeleteMapping("/estates/{id}")
    public void deleteEstate(@PathVariable int id) {
        estateRepository.deleteById(id);
    }

    @PostMapping("/addestate")
    public String addEstate(Estate user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        estateRepository.save(user);
        model.addAttribute("estates", estateRepository.findAll());
        return "index";
    }

    @PostMapping("/estate/{id}")
    public String updateUser(@PathVariable("id") int id, Estate estate,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            estate.setId(id);
            return "update-estate";
        }

        estateRepository.save(estate);
        model.addAttribute("users", estateRepository.findAll());
        return "index";
    }
}

