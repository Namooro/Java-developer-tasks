package com.epam.jdbcadvanced.service;

import com.epam.jdbcadvanced.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void batchInsert(List<User> users);
}
