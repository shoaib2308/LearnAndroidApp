package simplycodinghub.learnandroidapp.RetrofitListViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.Hero;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
