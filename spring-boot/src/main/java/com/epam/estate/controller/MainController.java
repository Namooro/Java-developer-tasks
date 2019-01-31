package com.epam.estate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Value("${application.message: Hi,Spring Booterrr!")
    private String message = "Default Message";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        return "welcome";
    }

}
