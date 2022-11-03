package com.example.madmleproject.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Users;

public class UsersRepo {
    private Users users;

    public UsersRepo(){
        users = new Users();
    }

    public static String createTable(){
        return "CREATE TABLE " + Users.TABLE + "("
                + Users.COLUMN_PK_ID + " INTEGER PRIMARY KEY, "
                + Users.COLUMN_USER_NAME + " TEXT UNIQUE NOT NULL, "
                + Users.COLUMN_PASSWORD + " TEXT NOT NULL, "
                + Users.COLUMN_NAME + " TEXT NOT NULL "
                + ");";
    }

    public int insert(Users user){
        int userId;
        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();
        ContentValues values = new ContentValues();
        values.put(Users.COLUMN_USER_NAME, user.getUsername());
        values.put(Users.COLUMN_PASSWORD, user.getPassword());
        values.put(Users.COLUMN_NAME, user.getName());

        userId = (int) db.insert(Users.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return userId;
    }

    public void delete(){
        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();
        db.delete(Users.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
