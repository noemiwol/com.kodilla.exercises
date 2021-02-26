package com.kodilla.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Subtasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @OneToMany(targetEntity = Users.class, mappedBy = "user_id")
    private List<Users> users = new ArrayList<>();

    public Subtasks() {
    }

    public Subtasks(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;

    }

    public List<Users> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

}
