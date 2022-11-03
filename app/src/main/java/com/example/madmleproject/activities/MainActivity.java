package com.example.madmleproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        insertSampleData();
    }

    public void goToHome(View view){
        Toast toast = Toast.makeText(this, "You are already here" , Toast.LENGTH_LONG);
        toast.show();
    }

    public void goToItinerary(View view){
        Intent intent = new Intent(this, BookmarkLocationAddOptionsActivity.class);
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

    private void insertSampleData(){
        UsersRepo usersRepo = new UsersRepo();
        LandmarksRepo landmarksRepo = new LandmarksRepo();
        LandmarkRatingsRepo landmarkRatingsRepo = new LandmarkRatingsRepo();
        BookmarksRepo bookmarksRepo = new BookmarksRepo();
        TripsRepo tripsRepo = new TripsRepo();
        ItinerariesRepo itinerariesRepo = new ItinerariesRepo();
        ArticlesRepo articlesRepo = new ArticlesRepo();
        ArticleCommentsRepo articleCommentsRepo = new ArticleCommentsRepo();

        usersRepo.delete();
        landmarksRepo.delete();
        landmarkRatingsRepo.delete();
        bookmarksRepo.delete();
        tripsRepo.delete();
        itinerariesRepo.delete();
        articlesRepo.delete();
        articleCommentsRepo.delete();

        //Insert Users
        Users user = new Users();
        user.setUsername("Matthijs");
        user.setPassword("123");
        user.setName("Matthijs van der Zaag");
        usersRepo.insert(user);

        user.setUsername("Mathias");
        user.setPassword("1234");
        user.setName("Mathias Jeppesen Engmark");
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

        landmark.setName("Kubang Badak Mangrove Reserve");
        landmark.setState("Perlis");
        landmark.setCity("Kedah");
        landmark.setAddress("Unnamed Road, Kampung Kelubi, 07000 Langkawi, Kedah");
        landmark.setDescription("Maecenas ipsum risus, varius eget eleifend sit amet, venenatis nec urna. Phasellus sit amet justo eu lacus fermentum vestibulum quis sed massa. Sed pharetra vitae nisl quis vestibulum. Nulla viverra erat eget quam pretium, in iaculis tellus bibendum. Maecenas posuere facilisis tellus, at facilisis mauris fringilla blandit. Donec placerat cursus quam in varius. Vivamus nec diam sed arcu sagittis gravida ac vel odio. Cras purus augue, mollis sed turpis id, lobortis sodales leo. Fusce sit amet erat metus. Phasellus non mattis est. Morbi non dapibus dolor. Curabitur tincidunt euismod lectus et mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce dapibus erat nec magna laoreet pulvinar. Curabitur quis pretium sem. Nulla facilisi.");
        landmark.setOperatingHours("ALL DAY");
        landmark.setPriceEntrance(0);
        landmark.setArticleAmount(0);
        landmarksRepo.insert(landmark);

        landmark.setName("Malacca Sand Dunes");
        landmark.setState("Melaka");
        landmark.setCity("Melaka Raya");
        landmark.setAddress("Malacca Sand Dunes Carpark, 75200 Klebang, Malacca");
        landmark.setDescription("In consectetur malesuada nunc, ac vehicula ipsum commodo nec. Proin nec commodo nulla. Sed in porta urna, sit amet volutpat turpis. Ut eget placerat ligula. Mauris metus nisi, dignissim quis ipsum et, auctor lobortis quam. Nam posuere justo posuere, blandit elit id, porttitor dui. Praesent vitae ornare tellus. Maecenas sed scelerisque arcu.");
        landmark.setOperatingHours("ALL DAY");
        landmark.setPriceEntrance(0);
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

        bookmark.setLandmarkId(2);
        bookmark.setUserId(1);
        bookmarksRepo.insert(bookmark);

        //bookmarksRepo.deleteSingleEntry(2, 1);

        //Insert Trips
        Trips trip = new Trips();
        trip.setUserId(1);
        trip.setState("Perlis");
        trip.setDateRange("01-01-2022, 10-01-2022");
        tripsRepo.insert(trip);

        trip.setUserId(1);
        trip.setState("Melaka");
        trip.setDateRange("20-02-2022, 30-02-2022");
        tripsRepo.insert(trip);

        //Insert for Itinerary 1
        Itineraries itinerary = new Itineraries();
        itinerary.setTripId(1);
        itinerary.setLandmarkId(3);
        itinerary.setDay(1);
        itinerariesRepo.insert(itinerary);

        itinerary.setTripId(1);
        itinerary.setLandmarkId(4);
        itinerary.setDay(2);
        itinerariesRepo.insert(itinerary);

        //Insert for Itinerary 2
        itinerary.setTripId(2);
        itinerary.setLandmarkId(2);
        itinerary.setDay(1);
        itinerariesRepo.insert(itinerary);

        itinerary.setTripId(2);
        itinerary.setLandmarkId(5);
        itinerary.setDay(2);
        itinerariesRepo.insert(itinerary);

        //Insert Articles
        Articles article = new Articles();
        article.setLandmarkId(1);
        article.setUserId(1);
        article.setArticleText("Phasellus odio eros, suscipit non ante non, mollis blandit est. Fusce pharetra sem est, in sodales dolor convallis et. Aenean ac varius dui, vel volutpat diam. Ut ipsum leo, aliquet sed velit et, imperdiet porttitor tellus. Nulla blandit ipsum ac consectetur elementum. Maecenas eu erat tempus, interdum ipsum et, dictum leo. Cras at dictum justo, id fringilla nisi. Nunc interdum accumsan dictum. Suspendisse fermentum nulla mi, vel lacinia nisi varius sed. Aliquam lectus erat, dapibus a felis semper, feugiat semper ligula. Nunc iaculis urna lorem, et pellentesque arcu vulputate id. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque nec elementum sapien, a tincidunt massa. Nam eget mauris a erat semper sagittis. Mauris pellentesque at nunc nec commodo.\n" +
                "\n" +
                "Praesent sed nisi ex. Aenean id rutrum risus, vitae pretium sapien. Vivamus pharetra enim ex, nec maximus justo auctor a. Donec quam risus, pellentesque vel aliquet sit amet, convallis in nulla. Praesent rhoncus ex at placerat viverra. Quisque blandit est ligula, ut efficitur odio facilisis vel. Nulla viverra vestibulum venenatis.\n" +
                "\n" +
                "In aliquam pharetra dui ullamcorper semper. Etiam faucibus odio diam, eget sodales urna fermentum id. Ut et mattis nunc. Donec id bibendum tortor. Quisque id convallis turpis. Vestibulum vestibulum velit in felis vulputate, eu aliquet augue congue. Donec aliquam volutpat semper. Nunc vitae magna libero. Sed blandit ligula nec erat sagittis aliquet.\n" +
                "\n" +
                "Nullam fermentum sem lectus, nec ullamcorper erat pretium in. Nulla nec maximus neque, nec tempus ante. Praesent sodales neque nulla, in posuere lorem rutrum sed. Sed semper odio non rhoncus mattis. Cras id erat lectus. Vivamus tincidunt diam ut fermentum tincidunt. Curabitur et nibh lorem. Quisque tincidunt leo eu hendrerit scelerisque. In quis dolor posuere, euismod quam a, suscipit quam. Nullam commodo imperdiet sollicitudin. Nunc sit amet neque libero.");
        article.setPicturePath("Unknown");
        article.setTitle("Must know about Petronas Towers");
        article.setLikes(0);
        article.setCommentAmount(0);
        articlesRepo.insert(article, landmarksRepo.getLandmarkArticleAmountFromId(article.getLandmarkId()));

        //Insert Article Comment
        ArticleComments articleComment = new ArticleComments();
        articleComment.setArticleId(1);
        articleComment.setUserId(2);
        articleComment.setComment("In consectetur malesuada nunc, ac vehicula ipsum commodo nec. Proin nec commodo nulla. Sed in porta urna, sit amet volutpat turpis. Ut eget placerat ligula. Mauris metus nisi, dignissim quis ipsum et, auctor lobortis quam. Nam posuere justo posuere, blandit elit id, porttitor dui. Praesent vitae ornare tellus. Maecenas sed scelerisque arcu.");
        articleComment.setLikes(0);
        articleCommentsRepo.insert(articleComment, articlesRepo.getArticleCommentAmountFromId(articleComment.getArticleId()));

        //Update Article Comments likes
        articleCommentsRepo.updateLikesBasedOnArticleCommentId(1);
        articleCommentsRepo.updateLikesBasedOnArticleCommentId(1);
        articleCommentsRepo.updateLikesBasedOnArticleCommentId(1);
        articleCommentsRepo.updateLikesBasedOnArticleCommentId(1);


        //Uncomment to see database while app's running
        DatabaseManager.getInstance().openDatabase();
    }


}