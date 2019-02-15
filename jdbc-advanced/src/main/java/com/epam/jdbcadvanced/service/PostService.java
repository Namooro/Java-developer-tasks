package com.epam.jdbcadvanced.service;

import com.epam.jdbcadvanced.model.Post;

import java.util.List;

public interface PostService {
    void batchInsert(List<Post> postList);
}
