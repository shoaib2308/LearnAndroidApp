package simplycodinghub.learnandroidapp.BestCodeRetrofit.services;

import java.util.List;

import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.Hero;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkApi;
import simplycodinghub.learnandroidapp.RetrofitListViewModel.NetworkGenerator2;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkListener;

public class HeroListApiService extends ViewModel implements Callback<List<Hero>>{
    protected NetworkListener networkListener;
    protected NetworkApi networkApi;
    protected int requestCode;


    public void submitServer(int requestCode , NetworkListener listener) {
        this.networkListener = listener;
        this.requestCode = requestCode;
        networkApi = NetworkGenerator2.createService(NetworkApi.class);
        this.networkApi.getHeroList().enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
        if (response.isSuccessful()) {
            networkListener.OnSuccess(response.body(), requestCode);
        }else{

        }
    }

    @Override
    public void onFailure(Call<List<Hero>> call, Throwable t) {

    }

}
