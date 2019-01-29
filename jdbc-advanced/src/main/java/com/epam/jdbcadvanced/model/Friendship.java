package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friendship")
public class Friendship {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User firstUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User secondUser;

    @Column(name = "addTime")
    private LocalDateTime addTime;

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public Friendship(User firstUser, User secondUser, LocalDateTime addTime) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.addTime = addTime;
    }

    public Friendship() {
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                ", addTime=" + addTime +
                '}';
    }
}
