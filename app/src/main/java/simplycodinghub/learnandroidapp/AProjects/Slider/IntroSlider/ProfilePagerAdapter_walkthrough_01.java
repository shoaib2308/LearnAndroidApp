package simplycodinghub.learnandroidapp.AProjects.Slider.IntroSlider;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ProfilePagerAdapter_walkthrough_01 extends FragmentStatePagerAdapter {



    public ProfilePagerAdapter_walkthrough_01(FragmentManager fm) {
        super(fm);

    }



    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_one tab1 = new Fragment_one();
                return tab1;

            case 1:
                Fragment_two tab2 = new Fragment_two();
                return tab2;


            case 2:
                Fragment_one tab3 = new Fragment_one();
                return tab3;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}