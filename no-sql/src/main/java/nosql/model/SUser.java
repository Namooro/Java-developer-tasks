package nosql.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "suser")
@Entity
public class SUser {
    @Id
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sUser")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sUser")
    private List<Like> likes = new ArrayList<>();

    public SUser(Integer userId, String name, String surname, LocalDate birthDate, List<Post> posts, List<Like> likes) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.posts = posts;
        this.likes = likes;
    }

    public SUser(Integer userid, String name, String surname, LocalDate birthDate) {
        this.userId = userid;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public SUser() {
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setsUser(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setsUser(null);
    }

    public void addLike(Like like) {
        likes.add(like);
        like.setsUser(this);
    }

    public void removeLike(Like like) {
        likes.remove(like);
        like.setsUser(null);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", post=" + posts +
                ", like=" + likes +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
