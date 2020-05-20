package simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.Hero;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.RegisterResponse2;
import simplycodinghub.learnandroidapp.RegisterRetrofit.RegisterResponse;

public interface NetworkApi {

    @FormUrlEncoded
    @POST("jojo/emp_reg_test.php")
    Call<RegisterResponse> sendRegister(@FieldMap Map<String, String> options);

    @FormUrlEncoded
    @POST("jojo/emp_reg_test.php")
    Call<RegisterResponse2> sendRegister2(@FieldMap Map<String, String> options);


    @GET("marvel")
    Call<List<Hero>> getHeroList();
}
