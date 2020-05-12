package simplycodinghub.learnandroidapp.FirebaseAnalytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

public class FA_Analytics {


    public static FA_Analytics getInstance(Activity p_activity) {
        if (mInstance == null) {
            synchronized (FA_Analytics.class) {
                mInstance = new FA_Analytics(p_activity);
            }
        }

        return mInstance;
    }

    public FA_Analytics(Activity p_activity) {
        activity = p_activity;
    }

    public void init(FirebaseApp fireBaseApp) {
        mFirebaseApp = fireBaseApp;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);

        Utils.d("Firebase Analytics initialized..!");
    }

    public void set_screen_name(final String s_name) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        mFirebaseAnalytics.setCurrentScreen(activity, s_name, null);

        Utils.d("Setting current screen to: " + s_name);
    }

    public void send_tutorial_complete() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, "11");

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.TUTORIAL_COMPLETE, bundle);
        Utils.d("Sending:Tutorial:Complete");
    }

    public void send_custom(final String key, final String value) {
        Bundle bundle = new Bundle();
        bundle.putString(key, value);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        mFirebaseAnalytics.logEvent("appEvent", bundle);
        Utils.d("Sending:App:Event:" + bundle.toString());
    }

    public void send_customData(final String userProperty, final String mobile, final String logEvent) {
        //
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        mFirebaseAnalytics.setUserProperty(userProperty,mobile);
        mFirebaseAnalytics.logEvent(logEvent,null);
        Utils.d("User:Screen: "+userProperty);
    }

    private static Context context;
    private static Activity activity = null;
    private static FA_Analytics mInstance = null;

    private FirebaseApp mFirebaseApp = null;
    private FirebaseAnalytics mFirebaseAnalytics = null;
}
