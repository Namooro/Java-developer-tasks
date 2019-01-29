package com.epam.jdbcadvanced.service.impl;

import com.epam.jdbcadvanced.model.User;
import com.epam.jdbcadvanced.repository.UserRepository;
import com.epam.jdbcadvanced.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void batchInsert(List<User> users) {
        userRepository.saveAll(users);
    }


}
