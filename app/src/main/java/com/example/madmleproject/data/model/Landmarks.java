package com.example.madmleproject.data.model;

public class Landmarks {
    public static final String TAG = Landmarks.class.getSimpleName();
    public static final String TABLE = "Landmarks";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_LandmarkID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_STATE = "State";
    public static final String COLUMN_CITY = "City";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_OPERATING_HOURS = "OperatingHours";
    public static final String COLUMN_PRICE_ENTRANCE = "PriceEntrance";
    public static final String COLUMN_AVERAGE_RATING = "AverageRating";
    public static final String COLUMN_ARTICLE_AMOUNT = "ArticleAmount";

    //Java variables
    private String landmarkId, name, state, city, address, description, operatingHours, priceEntrance, averageRating, articleAmount;


    public String getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(String landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getPriceEntrance() {
        return priceEntrance;
    }

    public void setPriceEntrance(String priceEntrance) {
        this.priceEntrance = priceEntrance;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getArticleAmount() {
        return articleAmount;
    }

    public void setArticleAmount(String articleAmount) {
        this.articleAmount = articleAmount;
    }
}
