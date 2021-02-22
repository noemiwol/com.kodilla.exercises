package com.kodilla.kodillaByteManipulation.task;

import java.util.Random;

public class Student {
    private final String indexNumber;


    public Student(String indexNumber) {
        this.indexNumber = random();
    }

    private String random() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(Character.toChars(random.nextInt(20) + 70));
        }
        return builder.toString();
    }
}
