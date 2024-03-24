package com.example.myapplication4.store;

import com.example.myapplication4.entity.Person;
import com.example.myapplication4.entity.Student;
import com.example.myapplication4.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class MemoryPersonStore implements PersonStore {
    private final List<Person> people = new ArrayList<>();

    @Override
    public void addTeacher(String firstName, String lastNAme, String speciality) {
        int id = people.size();
        people.add(new Teacher(id, firstName, lastNAme, speciality));
    }

    @Override
    public void addStudent(String firstName, String lastNAme, int grade) {
        int id = people.size();
        people.add(new Student(id, firstName, lastNAme, grade));
    }

    @Override
    public List<Person> getAll() {
        return people;
    }
    @Override
    public void removeRecord(long id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).id == id) {
                people.remove(i);
                System.out.println("Запис з ID " + id + " видалено.");
                return;
            }
        }
        System.out.println("Неможливо знайти запис з ID " + id);
    }
}


