package com.example.madmleproject.app;

import android.app.Application;
import android.content.Context;

import com.example.madmleproject.data.DBHelper;
import com.example.madmleproject.data.DatabaseManager;

public class App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    public void onCreate(){
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializeInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}
