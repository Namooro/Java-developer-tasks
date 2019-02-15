package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @Column(name = "likeId")
    private Integer likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private SUser sUser;

    @Column(name = "likeTime")
    private LocalDate likeTime;

    public Like(Integer likeId, Post post, SUser sUser, LocalDate likeTime) {
        this.likeId = likeId;
        this.post = post;
        this.sUser = sUser;
        this.likeTime = likeTime;
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

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", post=" + post +
                ", likeTime=" + likeTime +
                '}';
    }

    public SUser getsUser() {
        return sUser;
    }

    public void setsUser(SUser sUser) {
        this.sUser = sUser;
    }

    public LocalDate getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(LocalDate likeTime) {
        this.likeTime = likeTime;
    }

    public Like() {
    }

}
