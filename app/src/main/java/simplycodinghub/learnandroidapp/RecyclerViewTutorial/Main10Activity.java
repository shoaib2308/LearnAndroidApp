package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
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

public class Main10Activity extends AppCompatActivity implements Adapter.onClickListener {
    IRestservice service;
    Adapter adapter;
    List<GetListResponse> getListResponses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.programmableList);

        adapter = new Adapter(this, getListResponses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getList();


    }

    public void getList() {
        service = ApiClient.getRetrofit().create(IRestservice.class);
        service.getJobList().enqueue(new Callback<List<GetListResponse>>() {
            @Override
            public void onResponse(Call<List<GetListResponse>> call, Response<List<GetListResponse>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Main10Activity.this, "success", Toast.LENGTH_SHORT).show();
                    getListResponses.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(Main10Activity.this, "Server returned an error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<GetListResponse>> call, Throwable error) {
                Toast.makeText(Main10Activity.this, "", Toast.LENGTH_SHORT).show();
                if (error instanceof IOException) {
                    Log.d("aaaa",""+error);
                    //inform the user and possibly retry
                    Toast.makeText(Main10Activity.this, "this is an actual network failure "+error, Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                } else {
                    Toast.makeText(Main10Activity.this, "conversion issues :("+error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    @Override
    public void setOnClickListener(String userId) {
        Toast.makeText(this, ""+userId, Toast.LENGTH_SHORT).show();
    }
}
