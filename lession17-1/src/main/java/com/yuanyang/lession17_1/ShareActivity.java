package com.yuanyang.lession17_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        TextView tv = (TextView) findViewById(R.id.tv);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        Intent intent = getIntent();
        if (intent != null) {
            String type = intent.getType();
            if (type.equalsIgnoreCase("text/plain")) {
                String text = intent.getStringExtra(Intent.EXTRA_TEXT);
                tv.setText("接收到一条新消息：" + text);
            } else if (type.equalsIgnoreCase("iamge/jpeg")) {
                Uri uri = intent.getData();
                iv.setImageURI(uri);
            }
        }
    }
}
