package com.yuanyang.lession25;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("开始下载");
        new Thread() {

            @Override
            public void run() {
                int incr;
                for (incr = 0; incr <= 100; incr += 10) {
                    builder.setProgress(0, 0, true);
                    manager.notify(1, builder.build());
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setProgress(0, 0, false);
                manager.notify(1, builder.setContentText("下载完成").build());
            }
        }.start();


    }
}
