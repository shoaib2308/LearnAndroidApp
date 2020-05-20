package simplycodinghub.learnandroidapp.AProjects.Slider.IntroSlider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import simplycodinghub.learnandroidapp.R;

public class Fragment_two extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_two,container,false);
        return view;
    }
}
