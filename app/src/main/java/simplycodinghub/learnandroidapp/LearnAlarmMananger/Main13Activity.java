package simplycodinghub.learnandroidapp.LearnAlarmMananger;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main13Activity extends AppCompatActivity {
    TextView test;
    Date currentTime;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main13);
        test = (TextView) findViewById(R.id.test);
        createNotificationChannel();
         currentTime = Calendar.getInstance().getTime();
        test.setText(""+currentTime);

/*        Toast.makeText(this, "Reminder set for 1 min ", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, ReminderBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Main13Activity.this, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1);
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);


        Toast.makeText(this, "Reminder set for 1 min ", Toast.LENGTH_LONG).show();

        Intent i2 = new Intent(this, ReminderBroadcast2.class);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(Main13Activity.this, 2, i2, 0);
        AlarmManager alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MINUTE, 2);
        alarmManager2.set(AlarmManager.RTC_WAKEUP,cal2.getTimeInMillis(),pendingIntent2);*/

        // also set alarm
        Context context = this.getApplicationContext();
        setRecurringAlarm(context);

    }

    // Not working
    private void setRecurringAlarm(Context context) {
        Toast.makeText(this, "Recurring start toast", Toast.LENGTH_LONG).show();
        // we know mobiletuts updates at right around 1130 GMT.
        // let's grab new stuff at around 11:45 GMT, inexactly
        Calendar updateTime = Calendar.getInstance();
        updateTime.setTimeZone(TimeZone.getTimeZone("GMT"));
        updateTime.set(Calendar.HOUR_OF_DAY, 7);
        updateTime.set(Calendar.MINUTE, 6);

        Intent downloader = new Intent(Main13Activity.this, AlarmReceiver2.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) this.getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, recurringDownload);
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Reminder channnel"+currentTime;
            String description = "channel for provider";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notif", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



   /*  SETTING ALARM-MANAGER
   Intent myIntent = new Intent(getApplicationContext(), SessionReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            getApplicationContext(), 1, myIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);

    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC,now.getTimeInMillis(),pendingIntent);*/


    /* CANCEL ALARM-MANAGER
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Intent myIntent = new Intent(getApplicationContext(), SessionReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            getApplicationContext(), 1, myIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);

    alarmManager.cancel(pendingIntent);*/

}
