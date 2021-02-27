package com.kodilla.jpa.domain;

import javax.persistence.*;
@Entity
public class Subtasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;


    public Subtasks() {
    }

    public Subtasks(Long id, String name, String status, Users users, Task task) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.users = users;
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

    public Users getUsers() {
        return users;
    }

    public Task getTask() {
        return task;
    }
}
