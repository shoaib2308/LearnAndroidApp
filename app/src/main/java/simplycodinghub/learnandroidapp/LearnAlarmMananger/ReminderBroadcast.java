package simplycodinghub.learnandroidapp.LearnAlarmMananger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import simplycodinghub.learnandroidapp.R;

import static android.content.Context.VIBRATOR_SERVICE;

public class ReminderBroadcast extends BroadcastReceiver {
    private MediaPlayer player;

    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else{
            vibrator.vibrate(200);
        }
        //MediaPlayer ring= MediaPlayer.create(getActivity(),R.raw.ring);
       // player = MediaPlayer.create(context, R.raw.rashid_alafasy);
        // This will play the ringtone continuously until we stop the service.
      //  player.setLooping(true);
        // It will start the player
       // player.start();


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notif")
                .setSmallIcon(R.drawable.ic_add_photo)
                .setContentTitle("Remind notification 1")
                .setContentText("Hey this is just testing notif")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200,builder.build());
    }
}
