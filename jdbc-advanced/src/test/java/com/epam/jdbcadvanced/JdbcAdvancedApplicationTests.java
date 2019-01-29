package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.model.Friendship;
import com.epam.jdbcadvanced.model.Like;
import com.epam.jdbcadvanced.model.Post;
import com.epam.jdbcadvanced.model.User;
import com.epam.jdbcadvanced.repository.FriendshipRepository;
import com.epam.jdbcadvanced.repository.LikeRepository;
import com.epam.jdbcadvanced.repository.PostRepository;
import com.epam.jdbcadvanced.repository.UserRepository;
import com.epam.jdbcadvanced.service.FriendshipService;
import com.epam.jdbcadvanced.service.LikeService;
import com.epam.jdbcadvanced.service.PostService;
import com.epam.jdbcadvanced.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    LikeService likeService;

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
        for (int i = 0; i < 30000; i++) {
            likeList.add(new Like(i, postList.get(ThreadLocalRandom.current().nextInt(0, 15000)),
                    userList.get(ThreadLocalRandom.current().nextInt(0, 1000)), LocalDate.now()));
        }
        likeService.batchInsert(likeList);
        //  assertEquals(1000, userRepository.findAll().size());
        // assertEquals(90000, friendshipRepository.findAll().size());
        assertEquals(15000, postRepository.findAll().size());
        assertEquals(30000, likeRepository.findAll().size());

    }
/*
    @After
    public void after() {
        friendshipRepository.deleteAll();
        postRepository.deleteAll();
        userRepository.deleteAll();
    }*/

}

