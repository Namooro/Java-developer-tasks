package com.epam.jdbcadvanced.service.impl;

import com.epam.jdbcadvanced.model.Friendship;
import com.epam.jdbcadvanced.repository.FriendshipRepository;
import com.epam.jdbcadvanced.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService {
    @Autowired
    FriendshipRepository friendshipRepository;

    @Override
    public void batchInsert(List<Friendship> friendships) {
        friendshipRepository.saveAll(friendships);
    }
}
