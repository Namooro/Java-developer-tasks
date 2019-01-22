package com.epam.estate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "agent_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Estate> estateList = new ArrayList<>();

    public Agent(Long id, String name, List<Estate> estateList) {
        this.id = id;
        this.name = name;
        this.estateList = estateList;
    }

    public List<Estate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<Estate> estateList) {
        this.estateList = estateList;
    }

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
                ", estateList=" + estateList +
                '}';
    }
}
