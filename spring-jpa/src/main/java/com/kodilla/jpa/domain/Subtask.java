package com.kodilla.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "Subtask_User",
            joinColumns = { @JoinColumn(name = "subTask_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Task_Subtask",
            joinColumns = { @JoinColumn(name = "subTask_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks = new ArrayList<>();

    public Subtask() {
    }

    public Subtask(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public List<User> getUsers() {
        return users;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
