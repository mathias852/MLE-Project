package com.example.madmleproject.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.R;
import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Landmarks;

public class BookmarkActivity extends AppCompatActivity {

    TextView informationAddress, informationOperatingHours, InformationPriceRange, bookmarkTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);

        informationAddress = findViewById(R.id.information_address);
        informationOperatingHours = findViewById(R.id.information_operating_hours);
        InformationPriceRange = findViewById(R.id.InformationPrice_range);
        bookmarkTitle = findViewById(R.id.bookmarkTitle);
    }

    public void goToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void goToTripBookmarkOptions(View view){
        Intent intent = new Intent(this, BookmarkOptionsActivity.class);
        startActivity(intent);

    }



    public void goToSearch(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


    public void goToCommunity(View view){
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }


}
