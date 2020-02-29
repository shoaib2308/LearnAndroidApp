package simplycodinghub.learnandroidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import simplycodinghub.learnandroidapp.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       ActivityMain2Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        user = new User();
        user.setName("Ravi Tamada");
        user.setEmail("ravi@androidhive.info");

        binding.setUser(user);
    }
}
