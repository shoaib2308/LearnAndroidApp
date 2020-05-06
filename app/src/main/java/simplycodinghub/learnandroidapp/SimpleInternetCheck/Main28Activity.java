package simplycodinghub.learnandroidapp.SimpleInternetCheck;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;
import simplycodinghub.learnandroidapp.Utils.MyUtils;

public class Main28Activity extends AppCompatActivity {
    // Activity declaration of textviews
    TextView connectionStatus;
    TextView connectivityInstruction;
    String connectionInstruction = "";
    String connectionStatus1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main28);
        connectionStatus = findViewById(R.id.connectionStatus);
        connectivityInstruction = findViewById(R.id.requestContainerInstruction);

        /**
         * Callback method for the onClick of the @+id/requestData button in activity_main.xml
         * httpbin is an amazing web service for testing HTTP libraries.
         * It has several great endpoints that can test pretty much everything you need in a HTTP library.
         *
         */

    }
        public void requestDataCallback(View view) {

            try {
                if (MyUtils.isNetworkReachable(this)) {
                    DataTask dataTask = new DataTask(mainActivityDataTaskNotification);
                    connectionInstruction = dataTask.execute("https://httpbin.org/get?arg1=1&arg2=2").get();
                    connectionStatus1 = "Connection Status: Online";
                } else {
                    connectionInstruction = "Please check your internet connection and try your request again.";
                    connectionStatus1 = "Connection Status: Offline";
                }

                mainActivityDataTaskNotification.notifyMainActivity(connectionStatus1, connectionInstruction);
            } catch (Exception e) {
                String connectionInstruction = e.getMessage();   String connectionStatus = "";
                mainActivityDataTaskNotification.notifyMainActivity(connectionStatus, connectionInstruction);
            }
        }



        /**
         * MainActivityDataTaskNotification (Closure) : Interface Method.
         */
        MainActivityDataTaskNotification mainActivityDataTaskNotification = new MainActivityDataTaskNotification() {
            @Override
            public void notifyMainActivity(String connStatus, String connInstruction) {
                connectivityInstruction.setText(connInstruction);
                connectionStatus.setText(connStatus);
            }
        };

}
