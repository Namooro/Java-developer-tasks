package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
