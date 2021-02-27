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
    @ManyToMany
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @OneToMany(targetEntity = Subtasks.class, mappedBy = "task")
    private List<Subtasks> subtaskss = new ArrayList<>();


    public Task() {
    }

    public Task(Long id, String name, String status, Users users) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public List<Subtasks> getSubtaskss() {
        return subtaskss;
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
