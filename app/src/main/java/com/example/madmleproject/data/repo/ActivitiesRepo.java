package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Activities;
import com.example.madmleproject.data.model.Users;

public class ActivitiesRepo {
    private Activities activities;

    public ActivitiesRepo(){
        activities = new Activities();
    }

    public static String createTable(){
        return "CREATE TABLE " + Activities.TABLE + "("
                + Activities.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Activities.COLUMN_FK_USER_ID + " INTEGER, "
                + Activities.COLUMN_STATE + " TEXT NOT NULL, "
                + Activities.COLUMN_DATE_RANGE + " TEXT UNIQUE NOT NULL, "
                + "FOREIGN KEY (" + Activities.COLUMN_FK_USER_ID + ") REFERENCES "
                + Users.TABLE + "(" + Users.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
