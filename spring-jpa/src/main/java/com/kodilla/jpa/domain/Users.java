package com.kodilla.jpa.domain;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;



    public Users() {
    }

    public Users(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;

    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Long getId() {
        return id;
    }

}
