package com.yuanyang.lession14;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private static final String TAG = "ShareActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));

    }
}
