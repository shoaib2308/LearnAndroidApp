package simplycodinghub.learnandroidapp.RetrofitListViewModel;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.adapters.HeroesAdapter;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.Hero;
import simplycodinghub.learnandroidapp.RetrofitListViewModel.viewModel.HeroesViewModel;
import simplycodinghub.learnandroidapp.R;

public class Main34Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;
    HeroesViewModel model;
    List<Hero> heroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main34);

        initViews();

        model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        getList();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getList() {
        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> heroList) {
                adapter = new HeroesAdapter(Main34Activity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }

}
