package simplycodinghub.learnandroidapp.NamazTime;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRestService {

     String Secret_Key = "6b17c1f35fb2f94fffaa1019151ef820";
     String Selected_city = "/bangalore";
     @FormUrlEncoded
     //@POST("/location/pune.json?key="+Secret_Key)
     @POST(Selected_city+".json")
     Call<TimeResponse> getTime(@Field("city") String city);
}
