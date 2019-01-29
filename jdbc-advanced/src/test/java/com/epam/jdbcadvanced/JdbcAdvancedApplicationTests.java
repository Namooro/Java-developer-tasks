package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.model.Friendship;
import com.epam.jdbcadvanced.model.Like;
import com.epam.jdbcadvanced.model.Post;
import com.epam.jdbcadvanced.model.User;
import com.epam.jdbcadvanced.repository.FriendshipRepository;
import com.epam.jdbcadvanced.repository.PostRepository;
import com.epam.jdbcadvanced.repository.UserRepository;
import com.epam.jdbcadvanced.service.FriendshipService;
import com.epam.jdbcadvanced.service.PostService;
import com.epam.jdbcadvanced.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcAdvancedApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendshipService friendshipService;

    @Autowired
    FriendshipRepository friendshipRepository;

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    public void simpleTest() {
        User firstUser = new User(1, "1", "1", LocalDate.now(), Collections.emptyList());
        User secondUser = new User(2, "2", "2", LocalDate.now(), Collections.emptyList());
        firstUser.setFriends(Collections.singletonList(firstUser));
        userRepository.save(firstUser);
        //secondUser.setFriends(Collections.singletonList(secondUser));
        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        Friendship friendship = new Friendship(1, userRepository.findByname("1"), userRepository.findByname("2"), LocalDate.now());
        //     friendshipRepository.save(friendship);
        assertEquals(2, userRepository.findAll().size());
        assertEquals(1, userRepository.findByname("1").getFriends().size());
        // assertEquals("1", userService.getUsers().stream().findAny().get().getName());

    }

    @Test
    public void batchInsertTest() {
        List<User> userList = new ArrayList<>();
        List<Friendship> friendshipList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        List<Like> likeList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            userList.add(new User(i, String.format("firstname{}", i), String.format("secondName{}", i), LocalDate.now(), Collections.emptyList()));
        }
        userService.batchInsert(userList);
        for (int i = 0; i < 15000; i++) {
            postList.add(new Post(i, userList.get(ThreadLocalRandom.current().nextInt(1, 1000)),
                    String.format("i am post with id: {}", i), LocalDate.now()));
        }
        postService.batchInsert(postList);
        for (int i = 0; i < 90000; i++) {
            friendshipList.add(new Friendship(i, userList.get(ThreadLocalRandom.current().nextInt(1, 1000)),
                    userList.get(ThreadLocalRandom.current().nextInt(1, 1000)), LocalDate.now()));
        }

        friendshipService.batchInsert(friendshipList);

        assertEquals(1000, userRepository.findAll().size());
        assertEquals(90000, friendshipRepository.findAll().size());
        assertEquals(15000, postRepository.findAll().size());

    }
/*
    @After
    public void after() {
        friendshipRepository.deleteAll();
        postRepository.deleteAll();
        userRepository.deleteAll();
    }*/

}

