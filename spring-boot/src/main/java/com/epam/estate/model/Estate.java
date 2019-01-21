package com.epam.estate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ESTATE")
public class Estate {

    public Estate() {
    }

    public Estate(Integer id, Integer area, String address, Integer views, Date sell_date, Agent agent_id) {
        this.id = id;
        this.area = area;
        this.address = address;
        this.views = views;
        this.sell_date = sell_date;
        this.agent_id = agent_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "area")
    private Integer area;

    @Column(name = "address")
    private String address;

    @Column(name = "views")
    private Integer views;

    @Column(name = "sell_date")
    private Date sell_date;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
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
                ", area=" + area +
                ", address='" + address + '\'' +
                ", views=" + views +
                ", sell_date=" + sell_date +
                ", agent_id=" + agent_id +
                '}';
    }
}
