package com.epam.estate.repository;

import com.epam.estate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {

}
