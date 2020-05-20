package simplycodinghub.learnandroidapp.AProjects.Slider.IntroSlider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import simplycodinghub.learnandroidapp.R;

public class Fragment_one extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }
}
