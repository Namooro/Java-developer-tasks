package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship,Integer> {
}
