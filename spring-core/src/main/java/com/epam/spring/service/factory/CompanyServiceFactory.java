package com.epam.spring.service.factory;

import com.epam.spring.service.CompanyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@Service
public class CompanyServiceFactory {

    @Autowired
    private List<CompanyService> companyServices;

    private static final Logger log = Logger.getLogger(CompanyServiceFactory.class);

    private static final Map<String, CompanyService> serviceCache = new HashMap<>();

    @PostConstruct
    public void init() {
        for (CompanyService service : companyServices) {
            log.info(format("Bean %s was added to service cache", service.getName()));
            serviceCache.put(service.getName(), service);
        }
    }

    public static CompanyService getServiceByName(String serviceName) {
        CompanyService service = serviceCache.get(serviceName);
        if (service == null) {
            throw new IllegalArgumentException(format("No service matches name : %s", serviceName));
        }
        return service;
    }

    @PreDestroy
    public void destroy() {
        for (CompanyService service : companyServices) {
            log.info(format("Bean %s is being removed from service cache", service.getName()));
        }
    }
}
