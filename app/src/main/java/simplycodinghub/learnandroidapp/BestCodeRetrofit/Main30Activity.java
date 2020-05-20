package simplycodinghub.learnandroidapp.BestCodeRetrofit;

import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.RegisterResponse2;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkListener;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.services.RegisterApiService;
import simplycodinghub.learnandroidapp.R;
public class Main30Activity extends AppCompatActivity implements NetworkListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main30);

        Map<String, String> params;
        params = new HashMap<>();
        params.put("mobile", "9148635342");
        params.put("password", "123456");
        params.put("name", "koko");
        /**
         * Included for Resend OTP in Register form, LastUpdate:- By Shoaib 28-04-2020
         */
        new RegisterApiService().submitServer(params, 1,this);
    }

    @Override
    public void OnSuccess(Object response, int requestCode) {
        if (requestCode == 1) {
           RegisterResponse2 loginResponse = (RegisterResponse2) response;
            Toast.makeText(this, "" + loginResponse.getStatus(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnError(int errorCode, int requestCode,String message) {

    }

}
