package com.epam.jdbcadvanced.service;

import com.epam.jdbcadvanced.model.Friendship;

import java.util.List;

public interface FriendshipService {
    void batchInsert(List<Friendship> friendships);
}
