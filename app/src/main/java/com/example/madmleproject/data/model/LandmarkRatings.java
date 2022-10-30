package com.example.madmleproject.data.model;

public class LandmarkRatings {
    public static final String TAG = LandmarkRatings.class.getSimpleName();
    public static final String TABLE = "LandmarkRatings";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_LandmarkRatingID";
    public static final String COLUMN_FK_LANDMARK_ID = "FK_LandmarkID";
    public static final String COLUMN_RATING = "Rating";

    private int landmarkRatingId, landmarkId;
    private double rating;

    public int getLandmarkRatingId() {
        return landmarkRatingId;
    }

    public void setLandmarkRatingId(int landmarkRatingId) {
        this.landmarkRatingId = landmarkRatingId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
