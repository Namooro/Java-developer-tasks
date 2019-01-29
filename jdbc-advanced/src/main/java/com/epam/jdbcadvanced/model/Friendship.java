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
    private SUser firstSUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "otherUserId")
    private SUser otherSUser;

    @Column(name = "addTime")
    private LocalDate addTime;

    public Friendship(Integer friendshipId, SUser firstSUser, SUser otherSUser, LocalDate addTime) {
        this.friendshipId = friendshipId;
        this.firstSUser = firstSUser;
        this.otherSUser = otherSUser;
        this.addTime = addTime;
    }

    public SUser getFirstSUser() {
        return firstSUser;
    }

    public void setFirstSUser(SUser firstSUser) {
        this.firstSUser = firstSUser;
    }

    public SUser getOtherSUser() {
        return otherSUser;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public void setOtherSUser(SUser otherSUser) {
        this.otherSUser = otherSUser;
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
                ", firstSUser=" + firstSUser +
                ", otherSUser=" + otherSUser +
                ", addTime=" + addTime +
                '}';
    }
}
