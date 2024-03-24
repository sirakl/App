package com.example.myapplication4.entity;

public class Student extends Person {
    public int grade;

    public Student(long id, String firstName, String lastName, int grade) {
        super(id, firstName, lastName);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Клас: " + grade;
    }
}
