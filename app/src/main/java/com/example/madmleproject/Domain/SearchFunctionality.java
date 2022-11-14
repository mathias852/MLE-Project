package com.example.madmleproject.Domain;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Landmarks;

public class SearchFunctionality {
    private String StateNameTitle = "Penang";

    private static SearchFunctionality searchFunctionality = null;

    public static SearchFunctionality getSearchFunctionality(){
        if (searchFunctionality == null){
            searchFunctionality = new SearchFunctionality();
        }
        return searchFunctionality;
    }

    public String getStateNameTitle() {
        return StateNameTitle;
    }

    public void setStateNameTitle(String stateNameTitle) {
        this.StateNameTitle = stateNameTitle;
    }

    public boolean checkIfStateNameIsValid(String stateName){
        SQLiteDatabase db = DatabaseManager.getInstance().openReadDatabase();

        Boolean isValid = false;

        Cursor cursor = db.rawQuery("SELECT " + Landmarks.COLUMN_PK_ID + ", "
                + Landmarks.COLUMN_STATE + " FROM " + Landmarks.TABLE
                + " WHERE " + Landmarks.COLUMN_STATE + " = ?", new String[] {stateName});

        isValid = cursor.moveToFirst();
        DatabaseManager.getInstance().closeDatabase();
        return isValid;
    }
}
