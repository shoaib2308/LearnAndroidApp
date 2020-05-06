package simplycodinghub.learnandroidapp.CheckInternetRetrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

public class RetrofitAPIClient {

    private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS);

    public static <S> S createService(Class<S> serviceClass, String uniqueID) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.header("OS", "ANDROID");
                requestBuilder.header("OS_VERSION", android.os.Build.VERSION.SDK_INT + "");
                requestBuilder.header("APP_ID", PACKAGE_NAME);
                requestBuilder.method(original.method(), original.body());
                // Log.d("HTTP_CHECK", original.body().toString());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build()).build();
        return retrofit.create(serviceClass);

    }




}
