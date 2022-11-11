package com.example.madmleproject.activities;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.madmleproject.Domain.RepoManager;
import com.example.madmleproject.Domain.SearchFunctionality;
import com.example.madmleproject.R;
import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.Landmarks;

public class SearchActivity extends AppCompatActivity {

    TextView stateNameTitle, penang_hill, kek_lok_si_temple, gurney_drive, batu_ferringhi;

    EditText searchTextInput;

    ImageView bookmarkIconPenangHill, bookmarkIconPenangHillBookmarked, bookmarkIconKekLokSiTemple,
            bookmarkIconKekLokSiTempleBookmarked, bookmarkIconGurneyDrive, bookmarkIconGurneyDriveBookmarked,
            bookmarkIconBatuFerringhi, bookmarkIconBatuFerringhiBookmarked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

        stateNameTitle = findViewById(R.id.stateNameTitle);
        searchTextInput = findViewById(R.id.searchTextInputSearchPage);

        //Name of Landmarks
        penang_hill = findViewById(R.id.penang_hill);
        kek_lok_si_temple = findViewById(R.id.kek_lok_si_temple);
        gurney_drive = findViewById(R.id.gurney_drive);
        batu_ferringhi = findViewById(R.id.batu_ferringhi);

        //Bookmark Icons
        bookmarkIconPenangHill = findViewById(R.id.bookmarkIconPenangHill);
        bookmarkIconKekLokSiTemple = findViewById(R.id.bookmarkIconKekLokSiTemple);
        bookmarkIconGurneyDrive = findViewById(R.id.bookmarkIconGurneyDrive);
        bookmarkIconBatuFerringhi = findViewById(R.id.bookmarkIconBatuFerringhi);

        bookmarkIconPenangHillBookmarked = findViewById(R.id.bookmarkIconPenangHillBookmarked);
        bookmarkIconKekLokSiTempleBookmarked = findViewById(R.id.bookmarkIconKekLokSiTempleBookmarked);
        bookmarkIconGurneyDriveBookmarked = findViewById(R.id.bookmarkIconGurneyDriveBookmarked);
        bookmarkIconBatuFerringhiBookmarked = findViewById(R.id.bookmarkIconBatuFerringhiBookmarked);

        stateNameTitle.setText(SearchFunctionality.getSearchFunctionality().getStateNameTitle());

        updateVisibilityPenangHill();
        updateVisibilityBatuFerringhi();
        updateVisibilityGurneyDrive();
        updateVisibilityKekLokSiTemple();

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
                    handled = true;
                }
            }
            return handled;
        });

    }

    public void updateBookmark(View view){
        String landmarkName = view.getContentDescription().toString();
        updateBookmarkLandmark(landmarkName);

        switch (landmarkName){
            case("Penang Hill"):
                updateVisibilityPenangHill();
                break;
            case("Kek Lok Si Temple"):
                updateVisibilityKekLokSiTemple();
                break;
            case ("Gurney Drive"):
                updateVisibilityGurneyDrive();
                break;
            case ("Batu Ferringhi"):
                updateVisibilityBatuFerringhi();
                break;
        }
    }


    private void updateVisibilityPenangHill(){
        String landmarkName = penang_hill.getText().toString();
        if(isBookmarked(RepoManager.getRepoManager().getLandmarkIdFromName(landmarkName))){
            bookmarkIconPenangHill.setVisibility(View.INVISIBLE);
            bookmarkIconPenangHillBookmarked.setVisibility(View.VISIBLE);
        } else{
            bookmarkIconPenangHill.setVisibility(View.VISIBLE);
            bookmarkIconPenangHillBookmarked.setVisibility(View.INVISIBLE);
        }
    }

    private void updateVisibilityKekLokSiTemple(){
        String landmarkName = kek_lok_si_temple.getText().toString();

        if(isBookmarked(RepoManager.getRepoManager().getLandmarkIdFromName(landmarkName))){
            bookmarkIconKekLokSiTemple.setVisibility(View.INVISIBLE);
            bookmarkIconKekLokSiTempleBookmarked.setVisibility(View.VISIBLE);
        } else {
            bookmarkIconKekLokSiTemple.setVisibility(View.VISIBLE);
            bookmarkIconKekLokSiTempleBookmarked.setVisibility(View.INVISIBLE);
        }
    }

    private void updateVisibilityGurneyDrive(){
        String landmarkName = gurney_drive.getText().toString();

        if(isBookmarked(RepoManager.getRepoManager().getLandmarkIdFromName(landmarkName))){
            bookmarkIconGurneyDrive.setVisibility(View.INVISIBLE);
            bookmarkIconGurneyDriveBookmarked.setVisibility(View.VISIBLE);
        } else {
            bookmarkIconGurneyDrive.setVisibility(View.VISIBLE);
            bookmarkIconGurneyDriveBookmarked.setVisibility(View.INVISIBLE);
        }
    }

    private void updateVisibilityBatuFerringhi(){
        String landmarkName = batu_ferringhi.getText().toString();

        if(isBookmarked(RepoManager.getRepoManager().getLandmarkIdFromName(landmarkName))){
            bookmarkIconBatuFerringhi.setVisibility(View.INVISIBLE);
            bookmarkIconBatuFerringhiBookmarked.setVisibility(View.VISIBLE);
        } else {
            bookmarkIconBatuFerringhi.setVisibility(View.VISIBLE);
            bookmarkIconBatuFerringhiBookmarked.setVisibility(View.INVISIBLE);
        }
    }

    @SuppressLint("Range")
    public boolean updateBookmarkLandmark(String landmarkName){
        boolean isNowUpdatedBookmarked = false;
        int landmarkId = 0;

        SQLiteDatabase db = DatabaseManager.getInstance().openWriteDatabase();

        //Get the ID of the landmark via name
        landmarkId = RepoManager.getRepoManager().getLandmarkIdFromName(landmarkName);

        if(!isBookmarked(landmarkId)) {
            Bookmarks bookmark = new Bookmarks();
            bookmark.setLandmarkId(landmarkId);
            bookmark.setUserId(1);
            RepoManager.getRepoManager().getBookmarksRepo().insert(bookmark);
            isNowUpdatedBookmarked = true;
        } else {
            RepoManager.getRepoManager().getBookmarksRepo().deleteSingleEntry(landmarkId, 1);
            isNowUpdatedBookmarked = true;
        }

        DatabaseManager.getInstance().closeDatabase();

        return isNowUpdatedBookmarked;
    }

    public boolean isBookmarked(int landmarkId){
        SQLiteDatabase db = DatabaseManager.getInstance().openReadDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Bookmarks.TABLE +
                " WHERE " + Bookmarks.COLUMN_PK_FK_LANDMARK_ID + " = ?", new String[] {String.valueOf(landmarkId)});

        //If false, the item is not bookmarked
        return cursor.moveToFirst();
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

    public void sorryNotSupported(View view){
        Toast toast = Toast.makeText(this, "Sorry, but bookmark option for this is not supported", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void createNewTrip(View view) {
    }

    public void addToExistingTrip(View view) {
    }
}
