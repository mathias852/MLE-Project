package com.example.madmleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Users;
import com.example.madmleproject.data.repo.LandmarksRepo;
import com.example.madmleproject.data.repo.UsersRepo;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        insertSampleData();
    }

    private void insertSampleData(){
        UsersRepo usersRepo = new UsersRepo();

        usersRepo.delete();

        Users user = new Users();
        user.setUsername("Matthijs");
        user.setPassword("123");
        user.setName("Matthijs van der Zaag");
        usersRepo.insert(user);

        //Uncomment to see database while app's running
        //DatabaseManager.getInstance().openDatabase();

    }
}