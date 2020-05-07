package simplycodinghub.learnandroidapp.BestCodeRetrofit;

public interface NetworkListener {
    void OnSuccess(Object response, int requestCode, int code);
    void OnError(int errorCode, int requestCode, String message);
}
