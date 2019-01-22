package com.epam.estate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ESTATE")
public class Estate {

    public Estate() {
    }

    @Column(name = "cost")
    private Integer cost;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address")
    private String address;

    public Estate(Long id, Integer cost, String address, Integer views, Date sell_date, Agent agent_id) {
        this.id = id;
        this.cost = cost;
        this.address = address;
        this.views = views;
        this.sell_date = sell_date;
        this.agent_id = agent_id;
    }

    @Column(name = "views")
    private Integer views;

    @Column(name = "sell_date")
    private Date sell_date;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public Agent getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Agent agent_id) {
        this.agent_id = agent_id;
    }

    @Override
    public String toString() {
        return "Estate{" +
                "id=" + id +
                ", cost=" + cost +
                ", address='" + address + '\'' +
                ", views=" + views +
                ", sell_date=" + sell_date +
                ", agent_id=" + agent_id +
                '}';
    }
}
