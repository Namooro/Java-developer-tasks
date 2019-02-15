package com.epam.jdbcadvanced.service;

import com.epam.jdbcadvanced.model.SUser;

import java.util.List;

public interface UserService {
    List<SUser> getUsers();

    void batchInsert(List<SUser> SUsers);
}
