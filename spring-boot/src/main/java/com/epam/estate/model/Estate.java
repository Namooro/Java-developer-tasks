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
    private Integer id;

    @Column(name = "address")
    private String address;
    @Column(name = "sell_date")
    private Date sellDate;

    @Column(name = "views")
    private Integer views;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Estate(Integer id, String address, Integer cost, Date sellDate, Integer views, Agent agent) {
        this.id = id;
        this.address = address;
        this.cost = cost;
        this.sellDate = sellDate;
        this.views = views;
        this.agent = agent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Estate{" +
                "id=" + id +
                ", cost=" + cost +
                ", address='" + address + '\'' +
                ", views=" + views +
                ", sellDate=" + sellDate +
                ", agent=" + agent +
                '}';
    }
}
