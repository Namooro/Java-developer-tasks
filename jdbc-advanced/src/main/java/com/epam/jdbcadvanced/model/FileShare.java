package com.epam.jdbcadvanced.model;

import javax.persistence.*;

@Entity
@Table(name = "fileShare")
public class FileShare {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "pic")
    private byte[] pic;

    public FileShare() {
    }

    public FileShare(Integer id, String name, byte[] pic) {
        this.id = id;
        this.name = name;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
