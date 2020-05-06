package simplycodinghub.learnandroidapp.FastInternetCheckLearn;

import android.animation.Animator;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main11Activity extends AppCompatActivity implements InternetConnectivityReceiver.ConnectivityReceiverListener{
   // private MyInternetConnectionReceiver myInternetConnectionReceiver;
    private TextView internetStatus;
    private RelativeLayout rltConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        internetStatus = (TextView) findViewById(R.id.txtMsgStatus);
        rltConnection = findViewById(R.id.rltConnection);

        //Custom check Create a network change broadcast receiver.
       //myInternetConnectionReceiver = new MyInternetConnectionReceiver(); // UNCOMMENT TO START

        /**
         * Auto Check for Internet Connection
         * We are creating and Receive network change Broadcast receiver.
         */
        registerReceiver(new InternetConnectivityReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Create an IntentFilter instance.

        //// Intent filter are used for broadcast receiver. ... An intent is an object that can
        // hold the os or other app activity and its data in uri form.It is started using startActivity(intent-obj).. \n
        // whereas IntentFilter can fetch activity information on os or other app activities.

        IntentFilter intentFilter = new IntentFilter();
        // Add network connectivity change action.
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        // Register the broadcast receiver with the intent filter object.

      //  registerReceiver(myInternetConnectionReceiver, intentFilter);  //UNCOMMENT TO START

        InternetConnectivityReceiver.connectivityReceiverListener = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(myInternetConnectionReceiver);
    }

    @Override
    public void onNetworkConnectionChanged(Boolean isConnected) {
        showMsgBar(isConnected);
    }

    // FOR CUSTOM CHECK INTERNET USING BROADCASTRECIEVER
   /* public class MyInternetConnectionReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            showMsgBar(netInfo != null && netInfo.isConnected());

        }
    }*/

    /**
     *
     * @param isConnected
     * this boolean variable will return connectivity status
     */
    private void showMsgBar(boolean isConnected) {
        if (isConnected) {
            rltConnection.setBackgroundColor(Color.GREEN);
            rltConnection.animate().alpha(1.0f).setDuration(4000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    rltConnection.setVisibility(View.VISIBLE);
                    internetStatus.setText("Connected");
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    rltConnection.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            }).start();
        } else {
            rltConnection.setBackgroundColor(Color.RED);
            rltConnection.animate().alpha(1.0f).setDuration(4000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    rltConnection.setVisibility(View.VISIBLE);
                    internetStatus.setText("Disconnected");
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    rltConnection.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            }).start();
        }
    }
}
