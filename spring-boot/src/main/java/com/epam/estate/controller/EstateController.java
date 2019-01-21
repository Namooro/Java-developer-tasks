package com.epam.estate.controller;

import com.epam.estate.service.EstateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EstateController {

    @Autowired
    private EstateService estateService;

    Logger logger = LoggerFactory.getLogger(EstateController.class);

    @RequestMapping(value = "/estates", method = RequestMethod.GET)
    public String estates(Model model) {
        model.addAttribute("estates", "");
        return "estates";
    }

    @RequestMapping(value = "/estates", method = RequestMethod.POST)
    public String estates(Long id) {
        estateService.view(id);
        return "OK";
    }

}
