package simplycodinghub.learnandroidapp.singulList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;

public class Main16Activity extends AppCompatActivity {
    IRestService iRestService;
    RecyclerView recyclerView;
    List<Datum> dataListResponse = new ArrayList<>();
    Adapter adapter;
    String unixTime;
    private onClickInterface onClickInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        onClickInterface = new onClickInterface() {
            @Override
            public void setClick(int roomId) {
                Toast.makeText(Main16Activity.this, "roomid " + roomId, Toast.LENGTH_LONG).show();
                Intent i = new Intent(Main16Activity.this, Main17Activity.class);
                i.putExtra("id", roomId);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);


            }
        };

        adapter = new Adapter(Main16Activity.this, dataListResponse, onClickInterface);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();   // getListResponses.remove(dataListResponse);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000L);
        long unixTime1 = timestamp.getTime();
        unixTime = Long.toString(unixTime1);
        // Toast.makeText(Main16Activity.this, "" + unixTime, Toast.LENGTH_LONG).show();

        getList(unixTime);
    }

    public void getList(final String unixTime) {
        iRestService = ApiClients.getRetrofit().create(IRestService.class);
        iRestService.getMainData(unixTime).enqueue(new Callback<MainDataResponse>() {
            @Override
            public void onResponse(Call<MainDataResponse> call, Response<MainDataResponse> response) {
                if (!response.body().getSuccess().toString().isEmpty()) {
                    //Toast.makeText(Main16Activity.this, "" + response.body().getData(), Toast.LENGTH_LONG).show();
                    dataListResponse.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(Main16Activity.this, "connection failed", Toast.LENGTH_LONG).show();
                }

                Log.d("aaaa", "" + response.body().getSuccess());


            }

            @Override
            public void onFailure(Call<MainDataResponse> call, Throwable t) {

            }
        });

    }

}
