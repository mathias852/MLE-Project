package com.example.madmleproject.data.model;

public class Agendas {
    public static final String TAG = Agendas.class.getSimpleName();
    public static final String TABLE = "Agendas";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_AgendaID";
    public static final String COLUMN_FK_ACTIVITY_ID = "FK_ActivityID";

    private String agendaId, activityId;

    public String getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(String agendaId) {
        this.agendaId = agendaId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
