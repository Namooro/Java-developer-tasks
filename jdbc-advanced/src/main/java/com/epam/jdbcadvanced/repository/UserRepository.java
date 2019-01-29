package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByname(String name);
}
