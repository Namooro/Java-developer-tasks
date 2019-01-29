package com.epam.jdbcadvanced.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "suser")
@Entity
public class SUser {
    @Id
    @Column(name="userId")
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friendship",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "otherUserId"))
    private List<SUser> friends;

    public SUser() {
    }

    public SUser(Integer userid, String name, String surname, LocalDate birthDate, List<SUser> friends) {
        this.userId = userid;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.friends = friends;
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

    public List<SUser> getFriends() {
        return friends;
    }

    public void setFriends(List<SUser> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", friends=" + friends +
                '}';
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
