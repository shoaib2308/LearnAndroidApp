package simplycodinghub.learnandroidapp.LearnAlarmMananger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import simplycodinghub.learnandroidapp.R;

import static android.content.Context.VIBRATOR_SERVICE;

class AlarmReceiver2 extends BroadcastReceiver {
    private static final String DEBUG_TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(DEBUG_TAG, "Recurring alarm; requesting download service.");
        Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(3000, VibrationEffect.CONTENTS_FILE_DESCRIPTOR));
        }else{
            vibrator.vibrate(3000);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notif2")
                .setSmallIcon(R.drawable.ic_add_photo)
                .setContentTitle("Recurring notification")
                .setContentText("Hey jojon this is just testing notif")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200,builder.build());

    }
}

