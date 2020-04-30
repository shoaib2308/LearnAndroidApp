package simplycodinghub.learnandroidapp.QuickBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnectedOrConnecting(context));
        }else{
            Log.d("bbbb","connectivityReceiverListener : null");
        }
    }

    private boolean isConnectedOrConnecting(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(Boolean isConnected);
    }
}