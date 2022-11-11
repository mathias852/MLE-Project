package com.example.madmleproject.Domain;

public class AddActivityManager {
    private String activityName;
    private int day;

    private static AddActivityManager activityManager = null;

    public static AddActivityManager getActivityManager(){
        if (activityManager == null){
            activityManager = new AddActivityManager();
        }
        return activityManager;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
