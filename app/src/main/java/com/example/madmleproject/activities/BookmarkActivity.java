package com.example.madmleproject.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.R;
import com.example.madmleproject.data.repo.BookmarksRepo;

public class BookmarkActivity extends AppCompatActivity {

    TextView informationAddress, informationOperatingHours, InformationPriceRange, bookmarkTitle;
    TextView penang_hill;

    ImageView bookmarkIconPenangHill, bookmarkIconPenangHillBookmarked;

    BookmarksRepo bookmarksRepo = RepoManager.getRepoManager().getBookmarksRepo();

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);

        informationAddress = findViewById(R.id.information_address);
        informationOperatingHours = findViewById(R.id.information_operating_hours);
        InformationPriceRange = findViewById(R.id.InformationPrice_range);
        bookmarkTitle = findViewById(R.id.bookmarkTitle);

        //Name of Bookmark
        penang_hill = findViewById(R.id.bookmarkTitle);

        //Bookmark Icons
        bookmarkIconPenangHill = findViewById(R.id.bookmarkIconPenangHill);
        bookmarkIconPenangHillBookmarked = findViewById(R.id.bookmarkIconPenangHillBookmarked);
        //Update
        updateVisibilityPenangHill();
    }


    public void updateBookmark(View view) {
        String landmarkName = view.getContentDescription().toString();
        bookmarksRepo.updateBookmarkLandmark(landmarkName);

        switch (landmarkName) {
            case ("Penang Hill"):
                updateVisibilityPenangHill();
                break;
        }
    }

    private void updateVisibilityPenangHill() {
        String landmarkName = penang_hill.getText().toString();
        if (bookmarksRepo.isBookmarked(RepoManager.getRepoManager().getLandmarksRepo().getLandmarkIdFromName(landmarkName))) {
            bookmarkIconPenangHill.setVisibility(View.INVISIBLE);
            bookmarkIconPenangHillBookmarked.setVisibility(View.VISIBLE);
        } else {
            bookmarkIconPenangHill.setVisibility(View.VISIBLE);
            bookmarkIconPenangHillBookmarked.setVisibility(View.INVISIBLE);
        }
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


    public void goToAddTripOverviewBookmark(View view) {
        Intent intent = new Intent(this, BookmarkOptionsActivity.class);
        startActivity(intent);
    }
}
