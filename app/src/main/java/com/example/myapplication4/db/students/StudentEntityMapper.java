package com.example.myapplication4.db.students;

import com.example.myapplication4.entity.Student;

public class StudentEntityMapper {

    public StudentDatabaseEntity toDatabaseEntity(Student student) {
        return new StudentDatabaseEntity(student.id, student.firstName, student.lastName, student.grade);
    }

    public Student fromDatabaseEntity(StudentDatabaseEntity entity) {
        return new Student(entity.id, entity.firstName, entity.lastName, entity.grade);
    }
}
