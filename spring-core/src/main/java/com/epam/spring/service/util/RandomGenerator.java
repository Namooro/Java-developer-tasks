package com.epam.spring.service.util;

import com.epam.spring.util.InjectRandomStringFromPredefinedList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //For task with different bean scopes
public class RandomGenerator {

    @Value("#{ T(java.lang.Math).random() * 10.0 }")
    private int randomExperience;

    public int getRandomExperience() {
        return randomExperience;
    }

    @InjectRandomStringFromPredefinedList(values = {"Moscow", "Samara", "Peter", "Kazan"})
    private String randomCity;

    public String getRandomCity() {
        return randomCity;
    }
}
