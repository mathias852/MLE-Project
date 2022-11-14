package com.example.madmleproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.Domain.SearchFunctionality;
import com.example.madmleproject.R;
import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.ArticleComments;
import com.example.madmleproject.data.model.Articles;
import com.example.madmleproject.data.model.Trips;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.Itineraries;
import com.example.madmleproject.data.model.LandmarkRatings;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;
import com.example.madmleproject.data.repo.ArticleCommentsRepo;
import com.example.madmleproject.data.repo.ArticlesRepo;
import com.example.madmleproject.data.repo.TripsRepo;
import com.example.madmleproject.data.repo.BookmarksRepo;
import com.example.madmleproject.data.repo.ItinerariesRepo;
import com.example.madmleproject.data.repo.LandmarkRatingsRepo;
import com.example.madmleproject.data.repo.LandmarksRepo;
import com.example.madmleproject.data.repo.UsersRepo;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    ImageButton homescreenHomeButton, homescreenSearchButton,homescreenSocialButton;

    EditText searchTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        RepoManager.getRepoManager();

        searchTextInput = findViewById(R.id.searchTextInput);

        searchTextInput.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if(searchTextInput.getText().toString().equals("")){
                    Toast toast = Toast.makeText(this, "Please enter a state name", Toast.LENGTH_LONG);
                    toast.show();
                } else if (!SearchFunctionality.getSearchFunctionality().checkIfStateNameIsValid(searchTextInput.getText().toString())) {
                    Toast toast = Toast.makeText(this, "Sorry, but the chosen state name is not supported yet", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                        Intent intent = new Intent(this, SearchActivity.class);
                        startActivity(intent);
                        SearchFunctionality.getSearchFunctionality().setStateNameTitle(searchTextInput.getText().toString());
                        handled = true;
                    }
                }
            return handled;
        });

    }

    public void goToHome(View view){
        Toast toast = Toast.makeText(this, "You are already here" , Toast.LENGTH_LONG);
        toast.show();
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

    public void goToArticle(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);
    }
}