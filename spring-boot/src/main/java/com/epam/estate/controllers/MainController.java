package com.epam.estate.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Value("${application.message: Hi,Spring Booterrr!")
    private String message = "Default Message";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        return "welcome";
    }
}
