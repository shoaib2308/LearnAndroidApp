package simplycodinghub.learnandroidapp.QuickBroadcast;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main22Activity extends AppCompatActivity implements MyReceiver.ConnectivityReceiverListener {
    TextView internetStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        internetStatus = (TextView) findViewById(R.id.internet_status);

        registerReceiver(new MyReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(new MyReceiver());
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyReceiver.connectivityReceiverListener = this;
    }


    @Override
    public void onNetworkConnectionChanged(Boolean isConnected) {
        showNetworkMessage(isConnected);
    }

    private void showNetworkMessage(Boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(this, "no internet", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "youre online", Toast.LENGTH_LONG).show();
        }

    }
}
