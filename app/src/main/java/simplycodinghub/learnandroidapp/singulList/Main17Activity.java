package simplycodinghub.learnandroidapp.singulList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;

public class Main17Activity extends AppCompatActivity {
    IRestService iRestService;
    TextView tv1, tv2, tv3;
    String unixTime;
    int roomid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        Intent i = getIntent();
        roomid = i.getIntExtra("id",-1);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        Toast.makeText(this,""+roomid,Toast.LENGTH_LONG).show();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000L);
        long unixTime1 = timestamp.getTime();
        unixTime = Long.toString(unixTime1);


       getDetails(roomid, unixTime);

    }

    private void getDetails(int roomId, String unixTime) {
        iRestService = ApiClients.getRetrofit().create(IRestService.class);
        iRestService.getLockDetails(roomId, unixTime).enqueue(new Callback<LockDetailsResponse>() {
            @Override
            public void onResponse(Call<LockDetailsResponse> call, Response<LockDetailsResponse> response) {
               // Toast.makeText(Main17Activity.this,""+response.body().getMAC(),Toast.LENGTH_LONG).show();
                tv1.setText(""+response.body().getMAC());
                tv2.setText(""+response.body().getName());
                tv3.setText("" + response.body().getSuccess().toString());
            }

            @Override
            public void onFailure(Call<LockDetailsResponse> call, Throwable t) {

            }
        });
    }
}
