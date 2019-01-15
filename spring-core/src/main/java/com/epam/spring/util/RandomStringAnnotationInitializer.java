package com.epam.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

/**
 * Task 6.
 * This class injects random city to {@link com.epam.spring.model.Employee}.
 * Value is taken from pre-defined list which is used as annotation param.
 */
public class RandomStringAnnotationInitializer implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomStringFromPredefinedList annotation = field.getAnnotation(InjectRandomStringFromPredefinedList.class);
            if (annotation != null) {
                if (!field.getType().equals(String.class))
                    throw new RuntimeException("@InjectRandomStringFromPredefinedList cannot be set above " + field.getType());
                if (Modifier.isFinal(field.getModifiers())) {
                    throw new RuntimeException("Unable to inject to final fields");
                }
                String[] values = annotation.values();
                String value = values[random.nextInt(values.length)];
                try {
                    field.setAccessible(true);
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
