package com.example.madmleproject.data.model;

public class Bookmarks {
    public static final String TAG = Bookmarks.class.getSimpleName();
    public static final String TABLE = "Bookmarks";

    //Labels for table columns names
    public static final String COLUMN_PK_FK_LANDMARK_ID = "PK_FK_LandmarkId";
    public static final String COLUMN_PK_FK_USER_ID = "PK_FK_UserId";

    private String landmarkId, userId;

    public String getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(String landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
