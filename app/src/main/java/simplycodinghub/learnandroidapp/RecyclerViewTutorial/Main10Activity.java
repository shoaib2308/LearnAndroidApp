package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;
import simplycodinghub.learnandroidapp.RegisterRetrofit.ApiClient;
import simplycodinghub.learnandroidapp.RegisterRetrofit.IRestservice;

public class Main10Activity extends AppCompatActivity {
    IRestservice service;
    Adapter adapter;
    List<GetListResponse> getListResponses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.programmableList);



        adapter = new Adapter(Main10Activity.this, getListResponses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getList();


    }

    public void getList() {
        service = ApiClient.getRetrofit().create(IRestservice.class);
        service.getJobList().enqueue(new Callback<List<GetListResponse>>() {
            @Override
            public void onResponse(Call<List<GetListResponse>> call, Response<List<GetListResponse>> response) {
                getListResponses.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GetListResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }
}
