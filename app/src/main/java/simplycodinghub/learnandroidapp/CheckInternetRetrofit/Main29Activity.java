package simplycodinghub.learnandroidapp.CheckInternetRetrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main29Activity extends AppCompatActivity implements InternetConnectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);



    }


    @Override
    public void onInternetUnavailable() {
        // hide content UI
        // show No Internet Connection UI
    }
}
