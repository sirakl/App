package com.example.myapplication4.entity;

public abstract class Person {
    public int id;
    public String firstName;
    public String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {return "Id: " +id +", Ім'я: " + firstName + ", Прізвище: " + lastName;
    }

}
