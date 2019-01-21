package com.epam.estate.repository;

import com.epam.estate.model.Estate;
import org.springframework.data.repository.CrudRepository;

public interface EstateRepository extends CrudRepository<Estate, Long> {

}
