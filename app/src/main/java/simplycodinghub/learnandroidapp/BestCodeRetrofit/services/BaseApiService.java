package simplycodinghub.learnandroidapp.BestCodeRetrofit.services;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import okhttp3.ResponseBody;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.models.BaseResponse;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkApi;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkGenerator;
import simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit.NetworkListener;

public class BaseApiService {
    protected NetworkListener networkListener;
    protected NetworkApi networkApi;
    protected int requestCode;
    protected Map<String, String> params;

    public void submitServerBase(Map<String, String> params, int requestCode, NetworkListener listener) {
        this.networkListener = listener;
        this.requestCode = requestCode;
        this.params = params;
        networkApi = NetworkGenerator.createService(NetworkApi.class);
    }

    void onResponseBase(ResponseBody errorBody) {
        if (errorBody == null) {
            networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, "Failed due to unknown error 1.0");
            return;
        }

        BaseResponse baseErrorResponse = new Gson().fromJson(errorBody.charStream(), BaseResponse.class);
        if (baseErrorResponse == null) {
            networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, "Failed due to unknown error 1.1");
        } else if (baseErrorResponse.getSuccess()) {
            networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, baseErrorResponse.getError());
        } else {
            networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, "Failed due to unknown error 1.2");
        }
    }

    void onFailureBase(Throwable t) {
        if (t instanceof IOException || t instanceof SocketTimeoutException || t instanceof ConnectException) {
            if (t instanceof SocketTimeoutException || t instanceof TimeoutException) {
                networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, "Failed due to unknown error 2.1");
            } else {
                networkListener.OnError(NetworkListener.ERROR_NO_INTERNET, this.requestCode, "Please check your internet connection");
            }
        } else {
            networkListener.OnError(NetworkListener.ERROR_UNKNOWN, this.requestCode, "Failed due to unknown error 2.2");
        }
    }

}
