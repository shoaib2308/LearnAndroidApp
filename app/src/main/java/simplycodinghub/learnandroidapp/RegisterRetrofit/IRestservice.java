package simplycodinghub.learnandroidapp.RegisterRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import simplycodinghub.learnandroidapp.RecyclerViewTutorial.GetListResponse;

public interface IRestservice {

    @FormUrlEncoded
    @POST("/jojo/emp_reg_test.php")
    Call<RegisterResponse> getRegister(@Field("mobile") String mobile);

    @GET("jojo/all_jobs.php")
    Call<List<GetListResponse>> getJobList();
}
