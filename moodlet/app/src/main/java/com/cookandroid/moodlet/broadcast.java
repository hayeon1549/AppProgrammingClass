package com.cookandroid.moodlet;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {//알람 시간이 되었을때 onReceive를 호출함

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);
        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder;
        if (Build.VERSION.SDK_INT >= 26) {
            Log.e("오레오","오레오레오");
            NotificationChannel mChannel = new NotificationChannel("andokdcapp", "andokdcapp", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(mChannel);
            notificationBuilder = new NotificationCompat.Builder(context, mChannel.getId());
        } else {
            notificationBuilder = new NotificationCompat.Builder(context);
        }

        notificationBuilder.setAutoCancel(true)
                .setSmallIcon(R.drawable.image_logo)
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setContentTitle("Mood;let")
                .setContentText("오늘도 감정을 기록해보러 갈까요?")
                .setContentIntent(pendingIntent);


        notificationManager.notify(0
                // ID of notification
                , notificationBuilder.build());

    }
}