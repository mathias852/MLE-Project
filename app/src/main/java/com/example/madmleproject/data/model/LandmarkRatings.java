package com.example.madmleproject.data.model;

public class LandmarkRatings {
    public static final String TAG = LandmarkRatings.class.getSimpleName();
    public static final String TABLE = "LandmarkRatings";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_LandmarkRatingID";
    public static final String COLUMN_FK_LANDMARK_ID = "FK_LandmarkID";
    public static final String COLUMN_RATING = "Rating";

    private String landmarkRatingId, landmarkId, rating;

    public String getLandmarkRatingId() {
        return landmarkRatingId;
    }

    public void setLandmarkRatingId(String landmarkRatingId) {
        this.landmarkRatingId = landmarkRatingId;
    }

    public String getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(String landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
