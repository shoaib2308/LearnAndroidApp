package simplycodinghub.learnandroidapp.BestCodeRetrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.RegisterRetrofit.RegisterResponse;

public class RegisterApiService implements Callback<RegisterResponse> {
    public NetworkListener networkListener;
    NetworkApi networkApi;

    public void submitServer(Map<String, String> params, NetworkListener listener) {
        this.networkListener = listener;
        networkApi = NetworkGenerator.createService(NetworkApi.class);
        networkApi.sendRegister(params).enqueue(this);
    }

    @Override
    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
        if (response.isSuccessful()) {
            networkListener.OnSuccess(response.body(), response.code(), 1);
        }
    }

    @Override
    public void onFailure(Call<RegisterResponse> call, Throwable t) {
        // networkListener.OnError(""+t);
    }
}
