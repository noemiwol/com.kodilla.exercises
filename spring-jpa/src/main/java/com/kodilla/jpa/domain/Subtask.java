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

    @ManyToMany(mappedBy = "subtasks")
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name ="task_id")
    private Task task;

    public Subtask() {
    }

    public Subtask(Long id, String name, String status, Task task) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.task = task;
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

    public Task getTask() { return task; }
}
