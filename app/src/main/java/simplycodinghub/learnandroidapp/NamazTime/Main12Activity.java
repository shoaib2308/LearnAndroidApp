package simplycodinghub.learnandroidapp.NamazTime;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.CompassDirection.CompassActivity;
import simplycodinghub.learnandroidapp.R;

public class Main12Activity extends AppCompatActivity {
    TextView textView;
    IRestService iRestService;
    TimeAdapter timeAdapter;
    List<Item> timeListResponses = new ArrayList<>();
    RecyclerView timeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        textView = (TextView) findViewById(R.id.textView);
        timeList = (RecyclerView) findViewById(R.id.timeList);

        timeAdapter = new TimeAdapter(Main12Activity.this, timeListResponses);
        timeList.setLayoutManager(new LinearLayoutManager(this));
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main12Activity.this);
        timeList.setAdapter(timeAdapter);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main12Activity.this, CompassActivity.class);
                startActivity(i);
            }
        });
        getServerNameTime();
    }

    private void getServerNameTime() {
        iRestService = ApiClient.getRetrofit().create(IRestService.class);
        iRestService.getTime().enqueue(new Callback<TimeResponse>() {
            @Override
            public void onResponse(Call<TimeResponse> call, Response<TimeResponse> response) {
                //timeListResponses.addAll(response.body().getItems());
               // timeAdapter.notifyDataSetChanged();
                Log.d("ooooooooooo", "" + response.body().getItems());
                //Toast.makeText(Main12Activity.this,""+response.body().toString(),Toast.LENGTH_LONG).show();
                // textView.setText(response.body().getPrayerMethodName().toString());
            }

            @Override
            public void onFailure(Call<TimeResponse> call, Throwable t) {
                Log.e("ffffffffffffff", "NET_ERROR:" + t.toString());
                Toast.makeText(Main12Activity.this, "failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
