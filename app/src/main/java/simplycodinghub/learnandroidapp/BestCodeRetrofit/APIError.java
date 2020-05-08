package simplycodinghub.learnandroidapp.BestCodeRetrofit;

public class APIError {
    private Boolean success;
    private Boolean ATExpired;
    private String error;
    private Boolean deviceRestricted;

    public Boolean getDeviceRestricted() { return deviceRestricted; }
    public Boolean getSuccess() {
        return success;
    }

    public Boolean getATExpired() {
        return ATExpired;
    }

    public String getError() {
        return error;
    }
}
