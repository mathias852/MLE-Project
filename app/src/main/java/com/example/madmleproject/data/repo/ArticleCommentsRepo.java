package com.example.madmleproject.data.repo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.ArticleComments;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Landmarks;
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

    public int insert(ArticleComments articlesComment, Articles article){
        int articleCommentID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(ArticleComments.COLUMN_FK_ARTICLE_ID, articlesComment.getArticleId());
        values.put(ArticleComments.COLUMN_FK_USER_ID, articlesComment.getUserId());
        values.put(ArticleComments.COLUMN_COMMENT_TEXT, articlesComment.getComment());
        values.put(ArticleComments.COLUMN_LIKES, articlesComment.getLikes());

        articleCommentID = (int) db.insert(ArticleComments.TABLE, null, values);

        int newCommentAmount = article.getCommentAmount() + 1;
        updateCommentAmountForSpecificArticle(article.getArticleId(), newCommentAmount);

        DatabaseManager.getInstance().closeDatabase();
        return articleCommentID;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(ArticleComments.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void updateCommentAmountForSpecificArticle(int articleId, int newCommentAmount){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Articles.COLUMN_COMMENT_AMOUNT, newCommentAmount);
        String whereClause = Articles.COLUMN_PK_ID + " = ?";
        String[] whereArgs = {String.valueOf(articleId)};
        db.update(Articles.TABLE, values, whereClause, whereArgs);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void updateLikesBasedOnArticleCommentId(int articleCommentId){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        int newLikes = getLikeAmountFromArticleCommentId(articleCommentId) + 1;

        ContentValues values = new ContentValues();
        values.put(ArticleComments.COLUMN_LIKES, newLikes);
        String whereClause = ArticleComments.COLUMN_PK_ID + " = ?";
        String[] whereArgs = {String.valueOf(articleCommentId)};
        db.update(ArticleComments.TABLE, values, whereClause, whereArgs);
        DatabaseManager.getInstance().closeDatabase();
    }

    @SuppressLint("Range")
    public int getLikeAmountFromArticleCommentId(int articleCommentId){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery("SELECT " + ArticleComments.COLUMN_PK_ID + ", "
        + ArticleComments.COLUMN_LIKES + " FROM " + ArticleComments.TABLE
        + " WHERE " + ArticleComments.COLUMN_PK_ID + " = ?", new String[] {String.valueOf(articleCommentId)});
        cursor.moveToFirst();

        DatabaseManager.getInstance().closeDatabase();
        return cursor.getInt(cursor.getColumnIndex(ArticleComments.COLUMN_LIKES));
    }

}
