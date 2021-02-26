package com.kodilla.jpa.domain;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;


    public Users() {
    }

    public Users(Long id, String name, String surName, Task task) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Task getTask() {
        return task;
    }

    public Long getId() {
        return id;
    }

}
