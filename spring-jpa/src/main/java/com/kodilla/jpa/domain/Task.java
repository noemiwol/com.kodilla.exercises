package com.kodilla.jpa.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;


    public Task() {
    }

    public Task(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
