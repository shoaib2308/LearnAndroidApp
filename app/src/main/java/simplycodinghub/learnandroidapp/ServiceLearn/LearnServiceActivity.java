package simplycodinghub.learnandroidapp.ServiceLearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class LearnServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_service);
    }

    // Start the service
    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

    // Stop the service
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }
}
