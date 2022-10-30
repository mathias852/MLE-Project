package com.example.madmleproject.data.repo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.LandmarkRatings;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

import java.util.ArrayList;

public class LandmarkRatingsRepo {
    private LandmarkRatings landmarkRatings;

    public LandmarkRatingsRepo(){
        landmarkRatings = new LandmarkRatings();
    }

    public static String createTable(){
        return "CREATE TABLE " + LandmarkRatings.TABLE + "("
                + LandmarkRatings.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + LandmarkRatings.COLUMN_FK_LANDMARK_ID + " INTEGER, "
                + LandmarkRatings.COLUMN_RATING + " REAL NOT NULL, "
                + "FOREIGN KEY (" + LandmarkRatings.COLUMN_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }

    public int insert (LandmarkRatings landmarkRating, Landmarks landmark){
        int landmarkRatingId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(LandmarkRatings.COLUMN_FK_LANDMARK_ID, landmarkRating.getLandmarkId());
        values.put(LandmarkRatings.COLUMN_RATING, landmarkRating.getRating());
        landmarkRatingId = (int) db.insert(LandmarkRatings.TABLE, null, values);

        //Updates the Landmarks average rating after a new record has been inserted
        updateAverageRatingForSpecificLandmark(landmark.getLandmarkId(), calculateAverageRatingsFromSpecificLandmark(landmark.getLandmarkId()));
        DatabaseManager.getInstance().closeDatabase();
        return landmarkRatingId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(LandmarkRatings.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    @SuppressLint("Range")
    public double calculateAverageRatingsFromSpecificLandmark(int landmarkId) {
        //Get Readable database
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        double averageRating = 0;

        //Query to get only the ratings based on the associated landmark ID
        Cursor cursor =  db.rawQuery( "select " + LandmarkRatings.COLUMN_RATING + " from " + LandmarkRatings.TABLE
                + " WHERE " + LandmarkRatings.COLUMN_FK_LANDMARK_ID + " = ? ", new String[] {String.valueOf(landmarkId)} );
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            averageRating += cursor.getDouble(cursor.getColumnIndex(LandmarkRatings.COLUMN_RATING));
            cursor.moveToNext();
        }

        averageRating = averageRating / cursor.getCount();
        DatabaseManager.getInstance().closeDatabase();

        return averageRating;
    }

    public void updateAverageRatingForSpecificLandmark(int landmarkId, double newAverageRating){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Landmarks.COLUMN_AVERAGE_RATING, newAverageRating);
        String whereClause = Landmarks.COLUMN_PK_ID + " = ?";
        String[] whereArgs = {String.valueOf(landmarkId)};
        db.update(Landmarks.TABLE, values, whereClause, whereArgs);

    }
}
