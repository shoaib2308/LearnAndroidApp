package simplycodinghub.learnandroidapp.LearnAlarmMananger.v12;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main14Activity extends AppCompatActivity {
    //Pending intent instance
    private PendingIntent pendingIntent;

    private RadioButton secondsRadioButton, minutesRadioButton, hoursRadioButton;

    //Alarm Request Code
    private static final int ALARM_REQUEST_CODE = 133;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        //Find id of all radio buttons
        secondsRadioButton = (RadioButton) findViewById(R.id.seconds_radio_button);
        minutesRadioButton = (RadioButton) findViewById(R.id.minutes_radio_button);
        hoursRadioButton = (RadioButton) findViewById(R.id.hours_radio_button);

        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(Main14Activity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(Main14Activity.this, ALARM_REQUEST_CODE, alarmIntent, 0);

        //Find id of Edit Text
        final EditText editText = (EditText) findViewById(R.id.input_interval_time);

        //Set On CLick over start alarm button
        findViewById(R.id.start_alarm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInterval = editText.getText().toString().trim();//get interval from edittext

                //check interval should not be empty and 0
                if (!getInterval.equals("") && !getInterval.equals("0"))
                    //finally trigger alarm manager
                    triggerAlarmManager(getTimeInterval(getInterval));

                startAt10();
            }
        });

        //set on click over stop alarm button
        findViewById(R.id.stop_alarm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Stop alarm manager
                stopAlarmManager();
            }
        });

    }

    //get time interval to trigger alarm manager
    private int getTimeInterval(String getInterval) {
        int interval = Integer.parseInt(getInterval);//convert string interval into integer

        //Return interval on basis of radio button selection
        if (secondsRadioButton.isChecked())
            return interval;
        if (minutesRadioButton.isChecked())
            return interval * 60;//convert minute into seconds
        if (hoursRadioButton.isChecked()) return interval * 60 * 60;//convert hours into seconds

        //else return 0
        return 0;
    }


    //Trigger alarm manager with entered time interval
    public void triggerAlarmManager(int alarmTriggerTime) {
        // get a Calendar object with current time
        Calendar cal = Calendar.getInstance();
        // add alarmTriggerTime seconds to the calendar object
        cal.add(Calendar.SECOND, alarmTriggerTime);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);//get instance of alarm manager
        manager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);//set alarm manager with entered timer by converting into milliseconds

        Toast.makeText(this, "Alarm Set for " + alarmTriggerTime + " seconds.", Toast.LENGTH_SHORT).show();
    }

    //Stop/Cancel alarm manager
    public void stopAlarmManager() {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);//cancel the alarm manager of the pending intent


        //Stop the Media Player Service to stop sound
        stopService(new Intent(Main14Activity.this, AlarmSoundService.class));

        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(AlarmNotificationService.NOTIFICATION_ID);

        Toast.makeText(this, "Alarm Canceled/Stop by User.", Toast.LENGTH_SHORT).show();
    }


    public void startAt10() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 20;

        /* Set the alarm to start at 10:30 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);

        /* Repeating on every 20 minutes interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, pendingIntent);
    }

}
