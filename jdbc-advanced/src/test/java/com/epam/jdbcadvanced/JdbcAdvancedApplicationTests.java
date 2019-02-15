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
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        List<SUser> sUsers = new ArrayList<>();
        List<Friendship> friendshipList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        List<Like> likeList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            sUsers.add(new SUser(i, String.format("firstname %s", i), String.format("secondName %S", i), LocalDate.now()));
        }
        userService.batchInsert(sUsers);

        for (int i = 0; i < 1500; i++) {
            postList.add(new Post(i, userRepository.findById(ThreadLocalRandom.current().nextInt(0, 1000)).get(),
                    String.format("i am post with id: %s", i), LocalDate.now()));
        }
        postService.batchInsert(postList);

        for (int i = 0; i < 3000; i++) {
            likeList.add(new Like(i , postRepository.findById(ThreadLocalRandom.current().nextInt(0, 100)).get(),
                    sUsers.get(ThreadLocalRandom.current().nextInt(0, 1000)), LocalDate.now()));
        }
        likeService.batchInsert(likeList);

        for (int i = 0; i < 900; i++) {
            friendshipList.add(new Friendship(i, sUsers.get(ThreadLocalRandom.current().nextInt(0, 1000)),
                    sUsers.get(ThreadLocalRandom.current().nextInt(0, 1000)), LocalDate.now()));
        }
        friendshipService.batchInsert(friendshipList);

        assertEquals(1000, userRepository.findAll().size());
        assertEquals(1500, postRepository.findAll().size());
        assertEquals(900, friendshipRepository.findAll().size());
        assertEquals(3000, likeRepository.findAll().size());
        assertNotNull(userRepository.distinctUsers(LocalDate.now().minusDays(10), LocalDate.now().plusDays(10)).stream().findAny().get());
    }

}

