package com.example.madmleproject.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.Domain.AddActivityManager;
import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.R;
import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.Itineraries;
import com.example.madmleproject.data.model.Landmarks;

public class BookmarkListActivity extends AppCompatActivity {

    ImageView penangImageView, kekLokSiTempleImageView, gurneyDriveImageView, batuFerringhiImageView;

    TextView penangTextView, kekLokSiTempleTextView, gurneyDriveTextView, batuFerringhiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_overview_bookmark);

        penangImageView = findViewById(R.id.penangImageView);
        kekLokSiTempleImageView = findViewById(R.id.kekLokSiTempleImageView);
        gurneyDriveImageView = findViewById(R.id.gurneyDriveImageView);
        batuFerringhiImageView = findViewById(R.id.batuFerringhiImageView);

        penangTextView = findViewById(R.id.penangTextView);
        kekLokSiTempleTextView = findViewById(R.id.kekLokSiTempleTextView);
        gurneyDriveTextView = findViewById(R.id.gurneyDriveTextView);
        batuFerringhiTextView = findViewById(R.id.batuFerringhiTextView);

        updateBookmarkImages();

    }
    @SuppressLint("Range")
    public void updateBookmarkImages(){
        Cursor cursor = RepoManager.getRepoManager().getBookmarksRepo().updateBookmarkImages();
        while (!cursor.isAfterLast()){
            int landmarkId = cursor.getInt(cursor.getColumnIndex(Bookmarks.COLUMN_PK_FK_LANDMARK_ID));
            String landmarkName = RepoManager.getRepoManager().getLandmarksRepo().getLandmarkNameFromId(landmarkId);

            switch (landmarkName){
                case("Penang Hill"):
                    penangImageView.setVisibility(View.VISIBLE);
                    penangTextView.setVisibility(View.VISIBLE);
                    break;
                case("Kek Lok Si Temple"):
                    kekLokSiTempleImageView.setVisibility(View.VISIBLE);
                    kekLokSiTempleTextView.setVisibility(View.VISIBLE);
                    break;
                case ("Gurney Drive"):
                    gurneyDriveImageView.setVisibility(View.VISIBLE);
                    gurneyDriveTextView.setVisibility(View.VISIBLE);
                    break;
                case ("Batu Ferringhi"):
                    batuFerringhiImageView.setVisibility(View.VISIBLE);
                    batuFerringhiTextView.setVisibility(View.VISIBLE);
                    break;
            }
            cursor.moveToNext();
        }
    }

    public void addToActivity(View view){
        AddActivityManager.getActivityManager().setActivityName(view.getContentDescription().toString());
        int landmarkId = RepoManager.getRepoManager().getLandmarksRepo().getLandmarkIdFromName(AddActivityManager.getActivityManager().getActivityName());

        insertActivityIntoItinerary(1, landmarkId, AddActivityManager.getActivityManager().getDay());

        Intent intent = new Intent(this, TripOverviewActivity.class);
        startActivity(intent);
    }

    public void insertActivityIntoItinerary(int tripId, int landmarkId, int day){
        Itineraries itinerary = new Itineraries();
        itinerary.setTripId(tripId);
        itinerary.setLandmarkId(landmarkId);
        itinerary.setDay(day);
        RepoManager.getRepoManager().getItinerariesRepo().insert(itinerary);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, TripOverviewActivity.class);
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


    public void goToTripOverview(View view) {
        Intent intent = new Intent(this, TripOverviewActivity.class);
        startActivity(intent);
    }
}
