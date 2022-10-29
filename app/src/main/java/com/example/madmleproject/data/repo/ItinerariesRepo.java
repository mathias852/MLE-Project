package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Agendas;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Itineraries;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

public class ItinerariesRepo {
    private Itineraries itineraries;

    public ItinerariesRepo(){
        itineraries = new Itineraries();
    }

    public static String createTable(){
        return "CREATE TABLE " + Itineraries.TABLE + "("
                + Itineraries.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Itineraries.COLUMN_FK_AGENDA_ID + " INTEGER, "
                + Itineraries.COLUMN_FK_LANDMARK_ID + " INTEGER, "
                + Itineraries.COLUMN_DAY + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + Itineraries.COLUMN_FK_AGENDA_ID+ ") REFERENCES "
                + Agendas.TABLE + "(" + Agendas.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE, "
                + "FOREIGN KEY (" + Itineraries.COLUMN_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
