package com.epam.homework.jdbcadvanced.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@EnableAutoConfiguration
@Table(name = "frienships")
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

    @Override
    public String toString() {
        return "Friendship{" +
                "firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                ", addTime=" + addTime +
                '}';
    }
}
