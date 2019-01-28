package com.epam.homework.jdbcadvanced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "frienships")
public class Friendships {

    @Column(name = "firstUser")
    private User firstUser;

    @Column(name = "secondUser")
    private User secondUser;

    @Column(name = "addTime")
    private Timestamp addTime;

}
