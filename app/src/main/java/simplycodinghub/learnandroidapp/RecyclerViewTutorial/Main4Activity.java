package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.R;

public class Main4Activity extends AppCompatActivity {
    String[] langauges = {"java", "php", "json", "java", "php", "json", "java", "php", "json"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        RecyclerView programmableList = (RecyclerView) findViewById(R.id.programmableList);
        programmableList.setLayoutManager(new LinearLayoutManager(this));
        programmableList.setAdapter(new ProgrammingAdapter(langauges));
    }
}
