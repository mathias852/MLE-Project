package com.example.madmleproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "University";
//
//    //Table Name
//    private static final String TABLE_NAME = "students";
//
//    //Table fields
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_NAME = "name";
//    private static final String COLUMN_SUBJECT = "subject";
//    private static final String COLUMN_MARKS = "marks";
//    private static final String COLUMN_GRADE = "grade";

    SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
