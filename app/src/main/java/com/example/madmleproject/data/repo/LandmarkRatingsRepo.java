package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.LandmarkRatings;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

public class LandmarkRatingsRepo {
    private LandmarkRatings landmarkRatings;

    public LandmarkRatingsRepo(){
        landmarkRatings = new LandmarkRatings();
    }

    public static String createTable(){
        return "CREATE TABLE " + LandmarkRatings.TABLE + "("
                + LandmarkRatings.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + LandmarkRatings.COLUMN_FK_LANDMARK_ID + " INTEGER, "
                + LandmarkRatings.COLUMN_RATING + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + LandmarkRatings.COLUMN_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
