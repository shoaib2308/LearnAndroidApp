package simplycodinghub.learnandroidapp.BestCodeRetrofit.services;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.RegisterResponse2;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkListener;

public class RegisterApiService extends BaseApiService implements Callback<RegisterResponse2> {

    public void submitServer(Map<String, String> params, int requestCode , NetworkListener listener) {
        super.submitServerBase(params,requestCode,listener);
        networkApi.sendRegister2(params).enqueue(this);
    }

    @Override
    public void onResponse(Call<RegisterResponse2> call, Response<RegisterResponse2> response) {
        if (response.isSuccessful()) {
            networkListener.OnSuccess(response.body(), requestCode);
        }else{
            super.onResponseBase(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<RegisterResponse2> call, Throwable t) {
         super.onFailureBase(t);
    }
}
