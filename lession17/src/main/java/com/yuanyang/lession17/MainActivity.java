package com.yuanyang.lession17;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 向其他应用发送数据
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendText(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "hello,this is a auful website :www.baidu.com");
        Intent chooser = Intent.createChooser(intent, "像其他应用发送文本数据");
        startActivity(chooser);
    }

    public void sendBinary(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        Resources resources = getResources();
        String path = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.mipmap.ic_launcher) + "/" + resources.getResourceTypeName(R.mipmap.ic_launcher) + "/" + resources.getResourceEntryName(R.mipmap.ic_launcher);
        Log.i(TAG, path);
        Uri uri = Uri.parse(path);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        Intent chooser = Intent.createChooser(intent, "像其他应用发送二进制数据");
        intent.setType("image/jpeg");
        startActivity(chooser);
    }
}
