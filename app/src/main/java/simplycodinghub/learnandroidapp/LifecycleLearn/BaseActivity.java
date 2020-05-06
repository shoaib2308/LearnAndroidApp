package simplycodinghub.learnandroidapp.LifecycleLearn;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.bottom_down, R.anim.bottom_top);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.bottom_down1, R.anim.bottom_top1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // overridePendingTransitionExit();
        overridePendingTransition(R.anim.bottom_down1, R.anim.bottom_top1);
    }

}
