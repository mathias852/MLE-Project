package com.example.madmleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.madmleproject.data.DatabaseManager;
import com.example.madmleproject.data.model.Bookmarks;
import com.example.madmleproject.data.model.LandmarkRatings;
import com.example.madmleproject.data.model.Landmarks;
import com.example.madmleproject.data.model.Users;
import com.example.madmleproject.data.repo.BookmarksRepo;
import com.example.madmleproject.data.repo.LandmarkRatingsRepo;
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
        LandmarksRepo landmarksRepo = new LandmarksRepo();
        LandmarkRatingsRepo landmarkRatingsRepo = new LandmarkRatingsRepo();
        BookmarksRepo bookmarksRepo = new BookmarksRepo();

        usersRepo.delete();
        landmarksRepo.delete();
        landmarkRatingsRepo.delete();
        bookmarksRepo.delete();

        //Insert Users
        Users user = new Users();
        user.setUsername("Matthijs");
        user.setPassword("123");
        user.setName("Matthijs van der Zaag");
        usersRepo.insert(user);

        //Insert Landmarks
        Landmarks landmark = new Landmarks();
        landmark.setName("Petronas Towers");
        landmark.setState("Kuala Lumpur");
        landmark.setCity("KLCC");
        landmark.setAddress("Concourse Level, Petronas Twin Tower, Lower Ground, Kuala Lumpur City Centre, 50088 Kuala Lumpur");
        landmark.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam imperdiet tellus a metus euismod, id faucibus mauris rutrum. Donec eget efficitur enim, at fermentum quam. Donec ut neque augue. Cras auctor accumsan ipsum, at sollicitudin ipsum volutpat at. Morbi tincidunt, felis vitae mattis molestie, lectus orci pharetra ante, ac tristique tellus diam at lectus. Pellentesque imperdiet volutpat mi, ac ullamcorper massa malesuada sed. Morbi sed dignissim nisl. Cras auctor, mi sed euismod luctus, eros libero convallis felis, sed tempor felis nibh eget nibh. Cras varius nunc elit, vitae porttitor diam semper sed. Nulla a orci ac nunc pulvinar consequat. Sed vel nisi elementum, pharetra sapien eleifend, fermentum ante. Vivamus nec magna sit amet nibh aliquam maximus ut eget erat.");
        landmark.setOperatingHours("10am - 6pm");
        landmark.setPriceEntrance(100);
        landmark.setArticleAmount(0);
        landmarksRepo.insert(landmark);

        landmark.setName("Melaka Straits Mosque");
        landmark.setState("Melaka");
        landmark.setCity("Melaka Raya");
        landmark.setAddress("Jalan Pulau Melaka 8, 75000 Melaka");
        landmark.setDescription("Aliquam venenatis eros id porta tristique. Integer mattis tincidunt mi quis vehicula. In vitae augue id elit ultrices condimentum. Etiam vitae lorem velit. Vestibulum a nibh ipsum. Duis est urna, bibendum eu velit ac, feugiat scelerisque magna. Phasellus nisl nisl, semper sodales tristique eu, fermentum a urna. Suspendisse tempus diam nec condimentum lobortis. Maecenas rutrum velit ipsum, non scelerisque dui pulvinar in. Suspendisse nec lacus ut lorem dapibus aliquet. Pellentesque molestie mattis diam, et imperdiet libero pharetra et. Maecenas rutrum, risus vitae suscipit porta, sem leo imperdiet ipsum, vitae volutpat purus nisi lacinia risus. Aenean orci ex, congue ut dolor molestie, tristique vehicula turpis. Curabitur porta quis metus nec molestie. Maecenas venenatis ac lectus ut finibus. Pellentesque metus lacus, suscipit non ultrices a, mollis in turpis.");
        landmark.setOperatingHours("5am - 12am");
        landmark.setPriceEntrance(0);
        landmark.setArticleAmount(0);
        landmarksRepo.insert(landmark);

        landmark.setName("Langkawi SkyBridge");
        landmark.setState("Perlis");
        landmark.setCity("Kedah");
        landmark.setAddress("07000 Langkawi, Kedah");
        landmark.setDescription("Donec vitae pretium nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur consectetur erat nibh, et auctor sapien elementum a. Aenean facilisis aliquet luctus. Donec eget auctor velit. Duis in nulla tincidunt, aliquet ligula a, ullamcorper nisi. Maecenas semper dolor neque, sit amet venenatis dui ullamcorper vitae. Sed cursus dolor ac ex tempor, sed hendrerit est vulputate. Phasellus suscipit sapien sed ipsum faucibus, a pretium quam aliquam. Vivamus non commodo turpis, vitae semper ante. Vivamus malesuada justo neque, eu molestie metus semper vel. Fusce ipsum augue, vulputate ut sodales eget, egestas id arcu. Fusce gravida finibus magna a tempus. Fusce libero nisi, condimentum vitae commodo at, bibendum vel nisl. Sed arcu metus, tempus non viverra eget, pretium eget ligula. Donec vestibulum sit amet enim id imperdiet.");
        landmark.setOperatingHours("9:30am - 7pm");
        landmark.setPriceEntrance(50);
        landmark.setArticleAmount(0);
        landmarksRepo.insert(landmark);

        //Insert Landmark Ratings
        LandmarkRatings landmarkRating = new LandmarkRatings();
        landmarkRating.setLandmarkId(1);
        landmarkRating.setRating(3.5);
        landmarkRatingsRepo.insert(landmarkRating, landmarksRepo.getLandmarkRatingFromId(1));

        landmarkRating.setLandmarkId(1);
        landmarkRating.setRating(1);
        landmarkRatingsRepo.insert(landmarkRating, landmarksRepo.getLandmarkRatingFromId(1));

        //Insert Bookmarks
        Bookmarks bookmark = new Bookmarks();
        bookmark.setLandmarkId(1);
        bookmark.setUserId(1);
        bookmarksRepo.insert(bookmark);

        //Uncomment to see database while app's running
        DatabaseManager.getInstance().openDatabase();

    }
}