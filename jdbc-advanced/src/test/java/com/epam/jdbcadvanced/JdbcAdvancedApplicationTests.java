package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.model.Friendship;
import com.epam.jdbcadvanced.model.Like;
import com.epam.jdbcadvanced.model.Post;
import com.epam.jdbcadvanced.model.SUser;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    LikeService likeService;

    @Test
    public void batchInsertTest() {
        List<SUser> SUserList = new ArrayList<>();
        List<Friendship> friendshipList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        List<Like> likeList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            SUserList.add(new SUser(i, String.format("firstname %s", i), String.format("secondName %S", i), LocalDate.now(), Collections.emptyList()));
        }
        userService.batchInsert(SUserList);
      /*  for (int i = 0; i < 15000; i++) {
            postList.add(new Post(i, SUserList.get(ThreadLocalRandom.current().nextInt(1, 1000)),
                    String.format("i am post with id: {}", i), LocalDate.now()));
        }
        postService.batchInsert(postList);*/
     /*   for (int i = 0; i < 90000; i++) {
            friendshipList.add(new Friendship(i, SUserList.get(ThreadLocalRandom.current().nextInt(1, 1000)),
                    SUserList.get(ThreadLocalRandom.current().nextInt(1, 1000)), LocalDate.now()));
        }
        friendshipService.batchInsert(friendshipList);*/
      /*  for (int i = 0; i < 30000; i++) {
            likeList.add(new Like(i, postList.get(ThreadLocalRandom.current().nextInt(0, 15000)),
                    SUserList.get(ThreadLocalRandom.current().nextInt(0, 1000)), LocalDate.now()));
        }
        likeService.batchInsert(likeList);*/
        //  assertEquals(1000, userRepository.findAll().size());
        // assertEquals(90000, friendshipRepository.findAll().size());
        // assertEquals(15000, postRepository.findAll().size());
        //assertEquals(30000, likeRepository.findAll().size());
        assertEquals(null, userRepository.findAll().stream().map(SUser::getName).collect(Collectors.toList()));

    }
/*
    @After
    public void after() {
        friendshipRepository.deleteAll();
        postRepository.deleteAll();
        userRepository.deleteAll();
    }*/

}

