package com.example.madmleproject.data.model;

public class Activities {
    public static final String TAG = Activities.class.getSimpleName();
    public static final String TABLE = "Activities";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ActivityID";
    public static final String COLUMN_FK_USER_ID = "FK_UserID";
    public static final String COLUMN_STATE = "State";
    public static final String COLUMN_DATE_RANGE = "DateRange";

    private String activityId, userId, state, dateRange;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
