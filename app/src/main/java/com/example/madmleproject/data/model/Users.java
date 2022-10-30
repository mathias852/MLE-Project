package com.example.madmleproject.data.model;

public class Users {
    public static final String TAG = Users.class.getSimpleName();
    public static final String TABLE = "Users";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_UserID";
    public static final String COLUMN_USER_NAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";

    private String userId, username, password, name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
