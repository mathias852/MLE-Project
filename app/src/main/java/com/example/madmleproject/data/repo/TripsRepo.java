package com.example.madmleproject.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Trips;
import com.example.madmleproject.data.model.Users;

public class TripsRepo {
    private Trips activities;

    public TripsRepo(){
        activities = new Trips();
    }

    public static String createTable(){
        return "CREATE TABLE " + Trips.TABLE + "("
                + Trips.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Trips.COLUMN_FK_USER_ID + " INTEGER, "
                + Trips.COLUMN_STATE + " TEXT NOT NULL, "
                + Trips.COLUMN_DATE_RANGE + " TEXT UNIQUE NOT NULL, "
                + "FOREIGN KEY (" + Trips.COLUMN_FK_USER_ID + ") REFERENCES "
                + Users.TABLE + "(" + Users.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }

    public int insert(Trips activity){
        int activityId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Trips.COLUMN_FK_USER_ID, activity.getUserId());
        values.put(Trips.COLUMN_STATE, activity.getState());
        values.put(Trips.COLUMN_DATE_RANGE, activity.getDateRange());

        activityId = (int) db.insert(Trips.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return activityId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Trips.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
