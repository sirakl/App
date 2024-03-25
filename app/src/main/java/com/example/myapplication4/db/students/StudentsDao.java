package com.example.myapplication4.db.students;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentsDao {
    @Query("SELECT * FROM students")
    List<StudentDatabaseEntity> getAll();

    @Query("SELECT * FROM students WHERE id IN (:personId)")
    StudentDatabaseEntity getById(long personId);

    @Insert
    void insert(StudentDatabaseEntity entity);

    @Query("DELETE FROM students WHERE id IN (:personId)")
    void removeById(long personId);
}
