package com.epam.estate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AGENT")
public class Agent {
    public Agent(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Agent() {
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
