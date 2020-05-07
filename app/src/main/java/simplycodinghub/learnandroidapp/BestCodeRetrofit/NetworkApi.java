package simplycodinghub.learnandroidapp.BestCodeRetrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import simplycodinghub.learnandroidapp.RegisterRetrofit.RegisterResponse;

public interface NetworkApi {

    @FormUrlEncoded
    @POST("jojo/emp_reg_test.php")
    Call<RegisterResponse> sendRegister(@FieldMap Map<String, String> options);
}
