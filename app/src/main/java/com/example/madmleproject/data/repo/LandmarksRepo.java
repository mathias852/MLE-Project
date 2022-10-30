package com.example.madmleproject.data.repo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

import java.util.ArrayList;

public class LandmarksRepo {
    private Landmarks landmarks;

    public LandmarksRepo(){
        landmarks = new Landmarks();
    }

    public static String createTable(){
        return "CREATE TABLE " + Landmarks.TABLE + "("
                + Landmarks.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Landmarks.COLUMN_NAME + " TEXT UNIQUE NOT NULL, "
                + Landmarks.COLUMN_STATE + " TEXT NOT NULL, "
                + Landmarks.COLUMN_CITY + " TEXT NOT NULL, "
                + Landmarks.COLUMN_ADDRESS + " TEXT NOT NULL, "
                + Landmarks.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                + Landmarks.COLUMN_OPERATING_HOURS + " TEXT NOT NULL, "
                + Landmarks.COLUMN_PRICE_ENTRANCE + " INTEGER NOT NULL, "
                + Landmarks.COLUMN_AVERAGE_RATING + " REAL, "
                + Landmarks.COLUMN_ARTICLE_AMOUNT + " INTEGER NOT NULL"
                + ");";
    }

    public int insert (Landmarks landmark){
        int landmarkId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Landmarks.COLUMN_NAME, landmark.getName());
        values.put(Landmarks.COLUMN_STATE, landmark.getState());
        values.put(Landmarks.COLUMN_CITY, landmark.getCity());
        values.put(Landmarks.COLUMN_ADDRESS, landmark.getAddress());
        values.put(Landmarks.COLUMN_DESCRIPTION, landmark.getDescription());
        values.put(Landmarks.COLUMN_OPERATING_HOURS, landmark.getOperatingHours());
        values.put(Landmarks.COLUMN_PRICE_ENTRANCE, landmark.getPriceEntrance());
        values.put(Landmarks.COLUMN_AVERAGE_RATING, landmark.getAverageRating());
        values.put(Landmarks.COLUMN_ARTICLE_AMOUNT, landmark.getArticleAmount());

        landmarkId = (int) db.insert(Landmarks.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return landmarkId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Landmarks.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    @SuppressLint("Range")
    public Landmarks getLandmarkRatingFromId(int id){
        Landmarks landmark = new Landmarks();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery("SELECT " + Landmarks.COLUMN_PK_ID + ", "
                + Landmarks.COLUMN_AVERAGE_RATING + " FROM " + Landmarks.TABLE
                + " WHERE " + Landmarks.COLUMN_PK_ID + " = ?", new String[] {String.valueOf(id)});
        cursor.moveToFirst();

        //We only need the ID and Average rating of the landmark for this operation
        landmark.setLandmarkId(cursor.getInt(cursor.getColumnIndex(Landmarks.COLUMN_PK_ID)));
        landmark.setAverageRating(cursor.getDouble(cursor.getColumnIndex(Landmarks.COLUMN_AVERAGE_RATING)));
        DatabaseManager.getInstance().closeDatabase();

        return landmark;
    }
}
