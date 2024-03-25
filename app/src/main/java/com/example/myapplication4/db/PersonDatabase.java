package com.example.myapplication4.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication4.db.students.StudentDatabaseEntity;
import com.example.myapplication4.db.students.StudentsDao;

@Database(version = 1, entities = {StudentDatabaseEntity.class})
public abstract class PersonDatabase extends RoomDatabase {
    public static final String NAME ="person_db";

    public abstract StudentsDao studentsDao();
}
