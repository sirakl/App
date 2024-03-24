package com.example.myapplication4.store;

import com.example.myapplication4.entity.Person;

import java.util.List;

public interface PersonStore {

    void addTeacher(String firstName, String lastNAme, String speciality);

    void addStudent(String firstName, String lastNAme, int grade);

    List<Person> getStudents();

    List<Person> getTeachers();

    List<Person> getAll();
    void removeRecord(long id);
}
