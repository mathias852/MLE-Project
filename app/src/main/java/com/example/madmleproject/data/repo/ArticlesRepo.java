package com.example.madmleproject.data.repo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
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

    public int insert(Articles articles, Landmarks landmark){
        int articleID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Articles.COLUMN_FK_LANDMARK_ID, articles.getLandmarkId());
        values.put(Articles.COLUMN_FK_USER_ID, articles.getUserId());
        values.put(Articles.COLUMN_ARTICLE_TEXT, articles.getArticleText());
        values.put(Articles.COLUMN_PICTURE_PATH, articles.getPicturePath());
        values.put(Articles.COLUMN_TITLE, articles.getTitle());
        values.put(Articles.COLUMN_LIKES, articles.getLikes());
        values.put(Articles.COLUMN_COMMENT_AMOUNT, articles.getCommentAmount());

        articleID = (int) db.insert(Articles.TABLE, null, values);

        int newArticleAmount = landmark.getArticleAmount() + 1;
        updateArticleAmountForSpecificLandmark(landmark.getLandmarkId(), newArticleAmount);

        DatabaseManager.getInstance().closeDatabase();
        return articleID;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Articles.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void updateArticleAmountForSpecificLandmark(int landmarkId, int newArticleAmount){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Landmarks.COLUMN_ARTICLE_AMOUNT, newArticleAmount);
        String whereClause = Landmarks.COLUMN_PK_ID + " = ?";
        String[] whereArgs = {String.valueOf(landmarkId)};
        db.update(Landmarks.TABLE, values, whereClause, whereArgs);
    }

    @SuppressLint("Range")
    public Articles getArticleCommentAmountFromId(int id){
        Articles article = new Articles();
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery("SELECT " + Articles.COLUMN_PK_ID + ", "
                + Articles.COLUMN_COMMENT_AMOUNT + " FROM " + Articles.TABLE
                + " WHERE " + Articles.COLUMN_PK_ID + " = ?", new String[] {String.valueOf(id)});
        cursor.moveToFirst();

        //We only need the ID and Average rating of the landmark for this operation
        article.setArticleId(cursor.getInt(cursor.getColumnIndex(Articles.COLUMN_PK_ID)));
        article.setCommentAmount(cursor.getInt(cursor.getColumnIndex(Articles.COLUMN_COMMENT_AMOUNT)));
        DatabaseManager.getInstance().closeDatabase();

        return article;
    }
}
