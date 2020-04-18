package simplycodinghub.learnandroidapp.LearnAlarmMananger.DailyNotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;


public class BootReceiver extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        Log.d("boot","boot completed");
        // Your code to execute when Boot Completd

        Intent i=new Intent(context, MyService2.class);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            context.startForegroundService(i);
        }
        else {
            context.startService(i);
        }


       /* Intent i = new Intent(context, MyService2.class);
        context.startService(i);*/

        Toast.makeText(context, "Booting Completed", Toast.LENGTH_LONG).show();

    }
}
