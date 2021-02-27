package com.kodilla.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;

    @ManyToMany
    @JoinTable(
            name = "Task_User",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<Task> tasks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Subtask_User",
            joinColumns = { @JoinColumn(name = "subTask_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<Subtask> subtasks = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String surName) {
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

    public List<Task> getTasks() { return tasks; }

    public List<Subtask> getSubtasks() { return subtasks; }
}
