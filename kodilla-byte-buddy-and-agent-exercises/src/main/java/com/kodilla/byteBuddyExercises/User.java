package com.kodilla.byteBuddyExercises;

public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void doSomething() {
        System.out.println("Name: " + name + " Age: " + age);
    }
}
