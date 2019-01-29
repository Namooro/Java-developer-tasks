package com.epam.jdbcadvanced.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Transactional
@Table(name = "friendship")
public class Friendship {

    @Id
    @Column(name = "friendshipId")
    private Integer friendshipId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User firstUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "otherUserId")
    private User otherUser;

    @Column(name = "addTime")
    private LocalDate addTime;

    public Friendship(Integer friendshipId, User firstUser, User otherUser, LocalDate addTime) {
        this.friendshipId = friendshipId;
        this.firstUser = firstUser;
        this.otherUser = otherUser;
        this.addTime = addTime;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getOtherUser() {
        return otherUser;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }

    public LocalDate getAddTime() {
        return addTime;
    }

    public Friendship() {
    }

    public void setAddTime(LocalDate addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "friendshipId=" + friendshipId +
                ", firstUser=" + firstUser +
                ", otherUser=" + otherUser +
                ", addTime=" + addTime +
                '}';
    }
}
