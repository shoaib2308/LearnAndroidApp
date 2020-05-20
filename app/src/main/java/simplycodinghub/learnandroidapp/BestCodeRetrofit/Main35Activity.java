package simplycodinghub.learnandroidapp.BestCodeRetrofit;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.adapters.HeroesAdapter;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.Hero;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkListener;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.services.HeroListApiService;
import simplycodinghub.learnandroidapp.R;

public class Main35Activity extends AppCompatActivity implements NetworkListener {
    HeroesAdapter adapter;
    RecyclerView recyclerView;
    List<Hero> heroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main35);

        initViews();

        new HeroListApiService().submitServer(1, this);

    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        adapter = new HeroesAdapter(this, heroList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void OnSuccess(Object response, int requestCode) {
        List<Hero> heroResponse = (List<Hero>) response;
        heroList.addAll(heroResponse);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnError(int errorCode, int requestCode, String message) {

    }
}
