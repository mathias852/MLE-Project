package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Activities;
import com.example.madmleproject.data.model.Agendas;

public class AgendasRepo {
    private Agendas agendas;

    public AgendasRepo(){
        agendas = new Agendas();
    }

    public static String createTable(){
        return "CREATE TABLE " + Agendas.TABLE + "("
                + Agendas.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Agendas.COLUMN_FK_ACTIVITY_ID + " INTEGER, "
                + "FOREIGN KEY (" + Agendas.COLUMN_FK_ACTIVITY_ID + ") REFERENCES "
                + Activities.TABLE + "(" + Activities.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
