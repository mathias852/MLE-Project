package com.example.madmleproject.data.model;

public class Itineraries {
    public static final String TAG = Itineraries.class.getSimpleName();
    public static final String TABLE = "Itineraries";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ItineraryID";
    public static final String COLUMN_FK_AGENDA_ID = "FK_AgendaID";
    public static final String COLUMN_FK_LANDMARK_ID = "FK_LandmarkID";
    public static final String COLUMN_DAY = "Day";

    private String itineraryId, agendaId, landmarkId, day;

    public String getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(String itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(String agendaId) {
        this.agendaId = agendaId;
    }

    public String getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(String landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
