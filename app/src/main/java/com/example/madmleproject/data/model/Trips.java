package com.example.madmleproject.data.model;

public class Trips {
    public static final String TAG = Trips.class.getSimpleName();
    public static final String TABLE = "Trips";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ActivityID";
    public static final String COLUMN_FK_USER_ID = "FK_UserID";
    public static final String COLUMN_STATE = "State";
    public static final String COLUMN_DATE_RANGE = "DateRange";

    private String state, dateRange;
    private int activityId, userId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }
}
