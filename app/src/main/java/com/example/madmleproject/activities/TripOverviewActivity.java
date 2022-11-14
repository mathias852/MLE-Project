package com.example.madmleproject.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.Domain.AddActivityManager;
import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.R;
import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Itineraries;

public class TripOverviewActivity extends AppCompatActivity {

    TextView addActivityDay1, addActivityDay2, addActivityDay3, addActivityDay4, addActivityDay5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_overview);

        addActivityDay1 = findViewById(R.id._add_activity_day1);
        addActivityDay2 = findViewById(R.id._add_activity_day2);
        addActivityDay3 = findViewById(R.id._add_activity_day3);
        addActivityDay4 = findViewById(R.id._add_activity_day4);
        addActivityDay5 = findViewById(R.id._add_activity_day5);

        updateItinerary();

    }

    @SuppressLint("Range")
    public void updateItinerary(){
        Cursor cursor = RepoManager.getRepoManager().getItinerariesRepo().updateItinerary();
        while (!cursor.isAfterLast()){
            int day = cursor.getInt(cursor.getColumnIndex(Itineraries.COLUMN_DAY));
            int landmarkId = cursor.getInt(cursor.getColumnIndex(Itineraries.COLUMN_FK_LANDMARK_ID));

            String landmarkName = RepoManager.getRepoManager().getLandmarksRepo().getLandmarkNameFromId(landmarkId);
            switch (day){
                case(1):
                    addActivityDay1.setText(landmarkName);
                    break;
                case(2):
                    addActivityDay2.setText((landmarkName));
                    break;
                case(3):
                    addActivityDay3.setText(landmarkName);
                    break;
                case(4):
                    addActivityDay4.setText(landmarkName);
                    break;
                case(5):
                    addActivityDay5.setText(landmarkName);
                    break;
            }
            cursor.moveToNext();
        }
        DatabaseManager.getInstance().closeDatabase();
    }

    public void goToAddTripOverviewBookmark(View view){
        AddActivityManager.getActivityManager().setDay(Integer.parseInt(view.getContentDescription().toString()));
        Intent intent = new Intent(this, BookmarkListActivity.class);
        startActivity(intent);
    }

    public void test(View view){
        Intent intent = new Intent(this, BookmarkListActivity.class);
        startActivity(intent);
    }
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


    public void goToCommunity(View view) {
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void goToBookmark(View view) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        startActivity(intent);
    }
}
