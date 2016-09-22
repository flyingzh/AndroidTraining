package com.yuanyang.lession24;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private NotificationCompat.Builder builder;
    private NotificationManager managerCompat;
    private Notification secondNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new NotificationCompat.Builder(this);
        Notification commonNotification = getCommonNotification("newMessage", "收到新的消息");
        secondNotification = getCommonNotification("newMessage11", "收到另外一条消息");
        managerCompat = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        managerCompat.notify(1, commonNotification);

    }

    private Notification getCommonNotification(String title, String content) {
        return builder.setContentTitle(title).setContentInfo(content).setSmallIcon(R.mipmap.ic_launcher).setAutoCancel(true).build();
    }

    public void next(View v) {
        managerCompat.notify(1, secondNotification);

    }

    public void cancel(View v) {
        managerCompat.cancel(1);
    }
}
