package simplycodinghub.learnandroidapp.FirebaseAnalytics;

import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main21Activity extends AppCompatActivity {
    private FirebaseAnalytics firebaseAnalytics;
    //String[] foods;
    AnalyticsManager analytics;
    FA_Analytics fa_analytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);

        fa_analytics = new FA_Analytics(this);
        fa_analytics.init(FirebaseApp.initializeApp(this));

        fa_analytics.set_screen_name("MAIN_SCREEN");
        fa_analytics.send_customData(Utils.APP_LOGIN_SCREEN,"9148635342","login_track");

      //  foods = new String[]{"Apple", "Banana", "Grape", "Mango", "Orange"};

        // Obtain the Firebase Analytics instance.
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

/*
       First way

        Food food = new Food();
        food.setId(1);
        // choose random food name from the list
        food.setName(foods[randomIndex()]);

        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.ITEM_ID, food.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, food.getName());

        //Logs an app event.
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        //Sets whether analytics collection is enabled for this app on this device.
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        firebaseAnalytics.setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        firebaseAnalytics.setSessionTimeoutDuration(500);

        //Sets the user ID property.
        firebaseAnalytics.setUserId(String.valueOf(food.getId()));

        //Sets a user property to a given value.
        firebaseAnalytics.setUserProperty("Food", food.getName());*/


        
/*      SECOND WAY

        firebaseAnalytics.setUserId("jojo");
        firebaseAnalytics.setUserProperty("Food", food.getName());
        Bundle bundle2 = new Bundle();
        bundle2.putInt(FirebaseAnalytics.Param.ITEM_ID, food.getId());
        bundle2.putString(FirebaseAnalytics.Param.ITEM_NAME, food.getName());
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle2);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);*/


/**      THIRD WAY
 * Bundle bundle = new Bundle();
 * bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
 * bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
 * bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
 * mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
 *
 *                       OR
 *
 * Bundle params = new Bundle();
 * params.putString("image_name", name);
 * params.putString("full_text", text);
 * mFirebaseAnalytics.logEvent("share_image", params);
 */

        /* Implementing Firebase Analytics */
       /* firebaseAnalytics.setUserId("9148635342");
        firebaseAnalytics.setUserProperty("user_login_track","Shoaib");
        firebaseAnalytics.logEvent("APP_LOGIN_SCREEN", null);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN,null);*/
    }

   /* private int randomIndex() {
        int min = 0;
        int max = foods.length - 1;
        Random rand = new Random();
       return min + rand.nextInt((max - min) + 1);
    }*/




}
