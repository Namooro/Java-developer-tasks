package com.epam.spring.service;

import com.epam.spring.data.CompanyInformation;
import com.epam.spring.model.Position;
import org.apache.log4j.Logger;

import java.util.List;

import static java.lang.String.format;

public class PositionService implements CompanyService{

    private static final String SERVICE_NAME = "EmployeeService";

    private static final Logger log = Logger.getLogger(PositionService.class);

    public void add(Position position) {
        if (!CompanyInformation.positions.contains(position)) {
            CompanyInformation.positions.add(position);
            log.info(format("Added new position: %s", position));
        }
    }

    public void remove(Position position) {
        CompanyInformation.positions.remove(position);
        log.info(format("Removed position: %s", position));
    }

    public List<Position> getAll() {
        return CompanyInformation.positions;
    }

    @Override
    public String getName() {
        return SERVICE_NAME;
    }
}
