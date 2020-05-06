package simplycodinghub.learnandroidapp.FastInternetCheckLearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class InternetConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnectedOrConnecting(context));
        }else{
            Log.d("checkConnection","connectivityReceiverListener : null");
        }
    }

    private boolean isConnectedOrConnecting(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(Boolean isConnected);
    }


  // TO ACCESS

    /**
     * Check for Internet Connection
     * We are creating and Receive network change Broadcast receiver.
     */
    //registerReceiver(new InternetConnectivityReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


   /* @Override
    protected void onResume() {
        super.onResume();
        InternetConnectivityReceiver.connectivityReceiverListener = this;
    }*/

}
