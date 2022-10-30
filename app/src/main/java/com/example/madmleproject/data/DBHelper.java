package com.example.madmleproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.madmleproject.app.App;
import com.example.madmleproject.data.model.Activities;
import com.example.madmleproject.data.model.Agendas;
import com.example.madmleproject.data.model.ArticleComments;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.Itineraries;
import com.example.madmleproject.data.model.LandmarkRatings;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;
import com.example.madmleproject.data.repo.ActivitiesRepo;
import com.example.madmleproject.data.repo.AgendasRepo;
import com.example.madmleproject.data.repo.ArticleCommentsRepo;
import com.example.madmleproject.data.repo.ArticlesRepo;
import com.example.madmleproject.data.repo.BookmarksRepo;
import com.example.madmleproject.data.repo.ItinerariesRepo;
import com.example.madmleproject.data.repo.LandmarkRatingsRepo;
import com.example.madmleproject.data.repo.LandmarksRepo;
import com.example.madmleproject.data.repo.UsersRepo;

import java.io.File;

public class DBHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "Tripit";
    private static final String TAG = DBHelper.class.getSimpleName();


    public DBHelper() {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LandmarksRepo.createTable());
        db.execSQL(UsersRepo.createTable());
        db.execSQL(BookmarksRepo.createTable());
        db.execSQL(LandmarkRatingsRepo.createTable());
        db.execSQL(ActivitiesRepo.createTable());
        db.execSQL(AgendasRepo.createTable());
        db.execSQL(ItinerariesRepo.createTable());
        db.execSQL(ArticlesRepo.createTable());
        db.execSQL(ArticleCommentsRepo.createTable());
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d", oldVersion, newVersion));

        //Drop table if exists - NOTE ALL DATA WILL BE ERASED!!!
        db.execSQL("DROP TABLE IF EXISTS " + LandmarkRatings.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Itineraries.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Agendas.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Activities.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Bookmarks.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ArticleComments.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Articles.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Users.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Landmarks.TABLE);
        onCreate(db);
    }
}
