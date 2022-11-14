package com.example.madmleproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.R;

public class BookmarkOptionsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_location_add_options);
    }

    public void goToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void goToSearch(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


    public void goToCommunity(View view){
        Toast toast = Toast.makeText(this, "You are already here" , Toast.LENGTH_LONG);
        toast.show();
    }

    public void goToCalendar(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void addToExistingTrip(View view) {
        Toast toast = Toast.makeText(this, "Sorry, this feature is not supported yet", Toast.LENGTH_LONG);
        toast.show();
    }
}
