package simplycodinghub.learnandroidapp.BestCodeRetrofit.retrofit;

public interface NetworkListener {
    static int ERROR_UNKNOWN=1;
    static int ERROR_NO_INTERNET=2;


    void OnSuccess(Object response, int requestCode);
    void OnError(int errorCode, int requestCode, String message);


}
