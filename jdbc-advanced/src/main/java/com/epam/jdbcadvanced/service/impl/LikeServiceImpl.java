package com.epam.jdbcadvanced.service.impl;

import com.epam.jdbcadvanced.model.Like;
import com.epam.jdbcadvanced.repository.LikeRepository;
import com.epam.jdbcadvanced.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public void batchInsert(List<Like> likes) {
        likeRepository.saveAll(likes);
    }
}
