package com.example.myapplication4.db;

import android.content.Context;

import androidx.room.Room;

public class PersonDatabaseFactory {

    public PersonDatabase create(Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), PersonDatabase.class, PersonDatabase.NAME)
                .build();
    }
}
