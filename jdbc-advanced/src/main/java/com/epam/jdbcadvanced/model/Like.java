package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @Column(name = "likeId")
    private Integer likeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "likeTime")
    private LocalDateTime likeTime;

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", post=" + post +
                ", user=" + user +
                ", likeTime=" + likeTime +
                '}';
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }

    public Like(Integer likeId, Post post, User user, LocalDateTime likeTime) {
        this.likeId = likeId;
        this.post = post;
        this.user = user;
        this.likeTime = likeTime;
    }

    public Like() {
    }

}
