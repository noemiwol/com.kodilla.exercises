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
    @JoinTable(
            name = "Task_User",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<User> users = new ArrayList<>();

    @OneToMany
    @JoinTable(
            name = "Task_Subtask",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "subTask_id") })
    private List<Subtask> subtasks = new ArrayList<>();


    public Task() {
    }

    public Task(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
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
