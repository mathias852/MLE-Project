package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

public class BookmarksRepo {
    private Bookmarks bookmarks;

    public BookmarksRepo(){
        bookmarks = new Bookmarks();
    }

    public static String createTable(){
        return "CREATE TABLE " + Bookmarks.TABLE + "("
                + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + " INTEGER, "
                + Bookmarks.COLUMN_PK_FK_USER_ID + " INTEGER, "
                + "PRIMARY KEY (" + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + ", " + Bookmarks.COLUMN_PK_FK_USER_ID + "), "
                + "FOREIGN KEY (" + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE, "
                + "FOREIGN KEY (" + Bookmarks.COLUMN_PK_FK_USER_ID + ") REFERENCES "
                + Users.TABLE + "(" + Users.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
