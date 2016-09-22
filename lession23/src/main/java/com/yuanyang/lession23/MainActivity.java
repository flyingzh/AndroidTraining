package com.yuanyang.lession23;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * 高效的加载大图
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.post(new Runnable() {
            @Override
            public void run() {
                int requireHeight = iv.getMeasuredHeight();
                int requireWidth = iv.getMeasuredWidth();

            }
        });

    }


    private int caculateInSampleSize(BitmapFactory.Options options, int reqWith, int reqHeigh) {
        return 0;
    }

    class ImageTask implements Runnable {

        @Override
        public void run() {

        }
    }
}
