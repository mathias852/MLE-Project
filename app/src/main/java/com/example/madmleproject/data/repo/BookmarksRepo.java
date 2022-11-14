package com.example.madmleproject.data.repo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.data.DatabaseManager;
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

    public int insert (Bookmarks bookmark){
        int bookmarkId;
        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();
        ContentValues values = new ContentValues();
        values.put(Bookmarks.COLUMN_PK_FK_LANDMARK_ID, bookmark.getLandmarkId());
        values.put(Bookmarks.COLUMN_PK_FK_USER_ID, bookmark.getUserId());


        bookmarkId = (int) db.insert(Bookmarks.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return bookmarkId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();
        db.delete(Bookmarks.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteSingleEntry(int landmarkId, int userId){
        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();
        String whereClause = Bookmarks.COLUMN_PK_FK_USER_ID + " = ? AND " + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + " = ?";
        String[] whereArgs = {String.valueOf(userId), String.valueOf(landmarkId)};

        db.delete(Bookmarks.TABLE, whereClause, whereArgs);
        DatabaseManager.getInstance().closeDatabase();

    }

    @SuppressLint("Range")
    public void updateBookmarkLandmark(String landmarkName){
        int landmarkId = 0;

        //Get the ID of the landmark via name
        landmarkId = RepoManager.getRepoManager().getLandmarksRepo().getLandmarkIdFromName(landmarkName);

        if(!isBookmarked(landmarkId)) {
            Bookmarks bookmark = new Bookmarks();
            bookmark.setLandmarkId(landmarkId);
            bookmark.setUserId(1);
            RepoManager.getRepoManager().getBookmarksRepo().insert(bookmark);
        } else {
            RepoManager.getRepoManager().getBookmarksRepo().deleteSingleEntry(landmarkId, 1);
        }
    }

    public boolean isBookmarked(int landmarkId){
        SQLiteDatabase db = DatabaseManager.getInstance().openReadDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Bookmarks.TABLE +
                " WHERE " + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + " = ?", new String[] {String.valueOf(landmarkId)});

        //If false, the item is not bookmarked
        DatabaseManager.getInstance().closeDatabase();
        return cursor.moveToFirst();
    }

    @SuppressLint("Range")
    public Cursor updateBookmarkImages(){
        SQLiteDatabase db = DatabaseManager.getInstance().openReadDatabase();

        Cursor cursor = db.rawQuery("SELECT " + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + " FROM " +
                Bookmarks.TABLE + " WHERE " + Bookmarks.COLUMN_PK_FK_USER_ID + " = ?", new String[] {String.valueOf(1)});
        cursor.moveToFirst();

        DatabaseManager.getInstance().closeDatabase();
        return cursor;

    }
}
