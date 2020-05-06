package simplycodinghub.learnandroidapp.CheckInternetRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String URL = "https://api.example.com" + "/v1/";

    @GET("accounts/{accountId}")
    Call<AccountInfo> getAccountInfo(@Path("accountId") String accountId);
}
