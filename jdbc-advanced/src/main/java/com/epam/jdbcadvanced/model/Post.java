package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "postId")
    private Integer postId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private SUser SUser;

    @Column(name = "text")
    private String text;

    @Column(name = "post_time")
    private LocalDate time;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Post(Integer postId, SUser SUser, String text, LocalDate time) {
        this.postId = postId;
        this.SUser = SUser;
        this.text = text;
        this.time = time;
    }

    public SUser getSUser() {
        return SUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSUser(SUser SUser) {
        this.SUser = SUser;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", SUser=" + SUser +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
