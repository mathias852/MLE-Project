package com.example.madmleproject.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.ArticleComments;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Users;

public class ArticleCommentsRepo {
    private ArticleComments articleComments;

    public ArticleCommentsRepo(){
        articleComments = new ArticleComments();
    }

    public static String createTable(){
        return "CREATE TABLE " + ArticleComments.TABLE + "("
                + ArticleComments.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + ArticleComments.COLUMN_FK_ARTICLE_ID + " INTEGER, "
                + ArticleComments.COLUMN_FK_USER_ID + " INTEGER, "
                + ArticleComments.COLUMN_COMMENT_TEXT + " TEXT NOT NULL, "
                + ArticleComments.COLUMN_LIKES + " INTEGER, "
                + "FOREIGN KEY (" + ArticleComments.COLUMN_FK_ARTICLE_ID + ") REFERENCES "
                + Articles.TABLE + "(" + Articles.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE, "
                + "FOREIGN KEY (" + ArticleComments.COLUMN_FK_USER_ID + ") REFERENCES "
                + Users.TABLE + "(" + Users.COLUMN_PK_ID + ") "
                + "ON DELETE CASCADE "
                + ");";
    }

    public int insert(ArticleComments articlesComment){
        int articleCommentID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(ArticleComments.COLUMN_FK_ARTICLE_ID, articlesComment.getArticleId());
        values.put(ArticleComments.COLUMN_FK_USER_ID, articlesComment.getUserId());
        values.put(ArticleComments.COLUMN_COMMENT_TEXT, articlesComment.getComment());
        values.put(ArticleComments.COLUMN_LIKES, articlesComment.getLikes());


        articleCommentID = (int) db.insert(Users.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return articleCommentID;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(ArticleComments.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
