package com.example.myapplication4.db;

import android.content.Context;

import androidx.room.Room;

public class PersonDatabaseProvider {
    private static PersonDatabase personDatabase;

    public PersonDatabase provide(Context context) {
        if (personDatabase == null) {
            personDatabase = create(context);
        }
        return personDatabase;
    }

    private PersonDatabase create(Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), PersonDatabase.class, PersonDatabase.NAME)
                .allowMainThreadQueries()
                .build();
    }
}
