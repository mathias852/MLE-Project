package com.example.madmleproject.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Landmarks;

public class LandmarksRepo {
    private Landmarks landmarks;

    public LandmarksRepo(){
        landmarks = new Landmarks();
    }

    public static String createTable(){
        return "CREATE TABLE " + Landmarks.TABLE + "("
                + Landmarks.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Landmarks.COLUMN_NAME + " TEXT NOT NULL, "
                + Landmarks.COLUMN_STATE + " TEXT NOT NULL, "
                + Landmarks.COLUMN_CITY + " TEXT NOT NULL, "
                + Landmarks.COLUMN_ADDRESS + " TEXT NOT NULL, "
                + Landmarks.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                + Landmarks.COLUMN_OPERATING_HOURS + " TEXT NOT NULL, "
                + Landmarks.COLUMN_PRICE_ENTRANCE + " INTEGER, "
                + Landmarks.COLUMN_AVERAGE_RATING + " REAL, "
                + Landmarks.COLUMN_ARTICLE_AMOUNT + " INTEGER "
                + ");";
    }

//    public int insert (Landmarks landmarks){
//        int landmarkId;
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Landmarks.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
