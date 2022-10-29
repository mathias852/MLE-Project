package com.example.madmleproject.data.repo;

import com.example.madmleproject.data.model.Activities;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;

public class ArticlesRepo {
    private Articles articles;

    public ArticlesRepo(){
        articles = new Articles();
    }

    public static String createTable(){
        return "CREATE TABLE " + Articles.TABLE + "("
                + Articles.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Articles.COLUMN_FK_LANDMARK_ID + " INTEGER, "
                + Articles.COLUMN_FK_USER_ID + " INTEGER, "
                + Articles.COLUMN_ARTICLE_TEXT + " TEXT NOT NULL, "
                + Articles.COLUMN_PICTURE_PATH + " TEXT NOT NULL, "
                + Articles.COLUMN_TITLE + " TEXT NOT NULL, "
                + Articles.COLUMN_LIKES + " INTEGER, "
                + Articles.COLUMN_COMMENT_AMOUNT + " INTEGER, "
                + "FOREIGN KEY (" + Articles.COLUMN_FK_LANDMARK_ID + ") REFERENCES "
                + Landmarks.TABLE + "(" + Landmarks.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE, "
                + "FOREIGN KEY (" + Articles.COLUMN_FK_USER_ID + ") REFERENCES "
                + Users.TABLE + "(" + Users.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }
}
