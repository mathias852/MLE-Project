package com.example.madmleproject.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

    }

    public void goToHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToSearch(View view){
        Toast toast = Toast.makeText(this, "You are already here" , Toast.LENGTH_LONG);
        toast.show();
    }


    public void goToCommunity(View view){
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void goToBookmark(View view) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        startActivity(intent);

    }

    public void goToBookmarkOptions(View view) {
        Intent intent = new Intent(this, BookmarkOptionsActivity.class);
        startActivity(intent);
    }

    public void createNewTrip(View view) {
    }

    public void addToExistingTrip(View view) {
    }
}
