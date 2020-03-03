package simplycodinghub.learnandroidapp.NamazTime;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;

public class Main12Activity extends AppCompatActivity {
    TextView textView;
    IRestService iRestService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        textView = (TextView) findViewById(R.id.textView);
        getServerNameTime();
    }

    private void getServerNameTime() {
        iRestService = ApiClient.getRetrofit().create(IRestService.class);
        iRestService.getTime("pune").enqueue(new Callback<TimeResponse>() {
            @Override
            public void onResponse(Call<TimeResponse> call, Response<TimeResponse> response) {

                Log.d("ooooooooooo",""+response.body().getPrayerMethodName());
                Toast.makeText(Main12Activity.this,""+response.body().toString(),Toast.LENGTH_LONG).show();
                textView.setText(response.body().getPrayerMethodName().toString());
            }

            @Override
            public void onFailure(Call<TimeResponse> call, Throwable t) {
                Log.e("ffffffffffffff", "NET_ERROR:" + t.toString());
                Toast.makeText(Main12Activity.this,"failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
