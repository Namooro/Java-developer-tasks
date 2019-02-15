package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "postId")
    private Integer postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private SUser sUser;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<Like> likes = new ArrayList<>();

    public Post(Integer postId, SUser sUser, String text, LocalDate time) {
        this.postId = postId;
        this.sUser = sUser;
        this.text = text;
        this.time = time;
    }

    public void addLike(Like like) {
        likes.add(like);
        like.setPost(this);
    }

    public void removeLike(Like like) {
        likes.remove(like);
        like.setPost(null);
    }

    public SUser getsUser() {
        return sUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setsUser(SUser sUser) {
        this.sUser = sUser;
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
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
