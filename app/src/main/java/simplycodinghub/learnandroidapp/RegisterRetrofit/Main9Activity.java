package simplycodinghub.learnandroidapp.RegisterRetrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;

public class Main9Activity extends AppCompatActivity {
EditText mobile;
Button submit;
    IRestservice irestservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main9);

        mobile = (EditText) findViewById(R.id.mobile);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main9Activity.this, "click...", Toast.LENGTH_SHORT).show();
                String mMobile = mobile.getText().toString().trim();
                userRegister(mMobile);
            }
        });

    }

    public void userRegister(String mMobile) {
        irestservice = ApiClient.getRetrofit().create(IRestservice.class);
        irestservice.getRegister(mMobile).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d("aaaaaaaaaaa", "onResponse: "+response);
                Toast.makeText(Main9Activity.this, ""+response, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });

    }
}
