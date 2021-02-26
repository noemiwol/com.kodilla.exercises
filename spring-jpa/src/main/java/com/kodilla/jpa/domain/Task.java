package com.kodilla.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @OneToMany(targetEntity = Users.class, mappedBy = "user_id")
    private List<Users> users = new ArrayList<>();
    @OneToMany(targetEntity = Subtasks.class, mappedBy = "subtask_id")
    private List<Subtasks> subtask = new ArrayList<>();

    public Task() {
    }

    public Task(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public List<Users> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }
}
