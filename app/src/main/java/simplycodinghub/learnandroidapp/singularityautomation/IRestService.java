package simplycodinghub.learnandroidapp.singularityautomation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRestService {

     @GET("/v1/test/roomsList/")
     Call<MainDataResponse> getMainData(@Query("timestamp") String time);

     @GET("/v1/test/lockDetails")
     Call<LockDetailsResponse> getLockDetails(@Query("roomId") int roomId,
                                              @Query("timestamp") String time);
}
