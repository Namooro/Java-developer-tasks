package com.epam.jdbcadvanced.service.impl;

import com.epam.jdbcadvanced.model.Post;
import com.epam.jdbcadvanced.repository.PostRepository;
import com.epam.jdbcadvanced.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public void batchInsert(List<Post> posts) {
        postRepository.saveAll(posts);
    }
}
