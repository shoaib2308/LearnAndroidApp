package simplycodinghub.learnandroidapp.AProjects.Slider.IntroSlider;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;
import simplycodinghub.learnandroidapp.R;

public class Slider1Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private ProfilePagerAdapter_walkthrough_01 profilePagerAdapterWalkthrough01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        profilePagerAdapterWalkthrough01 = new ProfilePagerAdapter_walkthrough_01(getSupportFragmentManager());

        viewPager.setAdapter(profilePagerAdapterWalkthrough01);

        indicator.setViewPager(viewPager);

        profilePagerAdapterWalkthrough01.registerDataSetObserver(indicator.getDataSetObserver());


    }

}
