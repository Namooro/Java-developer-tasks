package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDate;

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
    private SUser SUser;

    @Column(name = "likeTime")
    private LocalDate likeTime;

    public Like(Integer likeId, Post post, SUser SUser, LocalDate likeTime) {
        this.likeId = likeId;
        this.post = post;
        this.SUser = SUser;
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
                ", SUser=" + SUser +
                ", likeTime=" + likeTime +
                '}';
    }

    public SUser getSUser() {
        return SUser;
    }

    public void setSUser(SUser SUser) {
        this.SUser = SUser;
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
