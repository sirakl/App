package com.example.myapplication4.store;

import android.content.Context;

import com.example.myapplication4.db.PersonDatabase;
import com.example.myapplication4.db.PersonDatabaseFactory;
import com.example.myapplication4.db.students.StudentEntityMapper;
import com.example.myapplication4.entity.Person;
import com.example.myapplication4.entity.PersonFilter;

import java.util.List;

public class DatabasePersonStore implements PersonStore {
    private final PersonDatabase personDatabase;
    private final StudentEntityMapper studentEntityMapper;

    public DatabasePersonStore(Context context) {
        this.personDatabase = new PersonDatabaseFactory().create(context);
        this.studentEntityMapper = new StudentEntityMapper();
    }

    @Override
    public void addTeacher(String firstName, String lastNAme, String speciality) {
    }

    @Override
    public void addStudent(String firstName, String lastNAme, int grade) {
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> getFiltered(PersonFilter personFilter) {
        return null;
    }

    @Override
    public void removeRecord(long id) {
    }
}
