package com.example.madmleproject.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Itineraries;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Trips;

public class ItinerariesRepo {
    private Itineraries itineraries;

    public ItinerariesRepo(){
        itineraries = new Itineraries();
    }

    public static String createTable(){
        return "CREATE TABLE " + Itineraries.TABLE + "("
                + Itineraries.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Itineraries.COLUMN_FK_TRIP_ID + " INTEGER, "
                + Itineraries.COLUMN_FK_LANDMARK_ID + " INTEGER, "
                + Itineraries.COLUMN_DAY + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + Itineraries.COLUMN_FK_TRIP_ID + ") REFERENCES "
                + Trips.TABLE + "(" + Trips.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE, "
                + "FOREIGN KEY (" + Itineraries.COLUMN_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }

    public int insert(Itineraries itinerary){
        int itineraryId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Itineraries.COLUMN_FK_TRIP_ID, itinerary.getTripId());
        values.put(Itineraries.COLUMN_FK_LANDMARK_ID, itinerary.getLandmarkId());
        values.put(Itineraries.COLUMN_DAY, itinerary.getDay());

        itineraryId = (int) db.insert(Itineraries.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return itineraryId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Itineraries.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
