package com.example.madmleproject.activities;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.R;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
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
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

    public void goToCalendar(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void goToArticle(View view){
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);
    }


}
