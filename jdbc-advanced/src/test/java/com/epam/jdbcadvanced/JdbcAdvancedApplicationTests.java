package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.model.User;
import com.epam.jdbcadvanced.repository.UserRepository;
import com.epam.jdbcadvanced.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcAdvancedApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void simpleTest() {
        User user = new User(1, "1", "2", LocalDate.now());
        userRepository.save(user);
        assertEquals("1", userRepository.findById(1).get().getName());
    }

}

