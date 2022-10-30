package com.example.madmleproject.data.model;

public class Itineraries {
    public static final String TAG = Itineraries.class.getSimpleName();
    public static final String TABLE = "Itineraries";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ItineraryID";
    public static final String COLUMN_FK_TRIP_ID = "FK_TripID";
    public static final String COLUMN_FK_LANDMARK_ID = "FK_LandmarkID";
    public static final String COLUMN_DAY = "Day";

    private int itineraryId, tripId, landmarkId, day;

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
