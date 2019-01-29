package com.epam.jdbcadvanced.service;

import com.epam.jdbcadvanced.model.Like;

import java.util.List;

public interface LikeService {
    void batchInsert(List<Like> likes);
}
