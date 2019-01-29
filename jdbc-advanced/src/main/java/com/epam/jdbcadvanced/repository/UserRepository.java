package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
