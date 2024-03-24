package com.example.myapplication4.store;

import com.example.myapplication4.entity.Person;
import com.example.myapplication4.entity.PersonFilter;

import java.util.List;

public interface PersonStore {

    void addTeacher(String firstName, String lastNAme, String speciality);

    void addStudent(String firstName, String lastNAme, int grade);

    List<Person> getAll();

    List<Person> getFiltered(PersonFilter personFilter);

    void removeRecord(long id);
}
