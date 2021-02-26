package com.kodilla.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Subtasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @OneToMany(targetEntity = Task.class, mappedBy = "task_id")
    private List<Task> tasks = new ArrayList<>();

    public Subtasks() {
    }

    public Subtasks(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;

    }

    public List<Task> getTasks() {
        return tasks;
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
