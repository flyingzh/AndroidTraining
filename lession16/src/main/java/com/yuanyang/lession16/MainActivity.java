package com.yuanyang.lession16;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * 动态申请权限
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //如果没有拍照权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //查看是否需要弹出说明对话框
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                Log.i(TAG, "should show rationnal");
                Toast.makeText(this, "没有拍照权限,请先设置拍照权限", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            } else {
                Log.i(TAG, "should not show rationnal");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            }
        } else {
            //do something
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i(TAG, "hasRequestPermission");
        if (requestCode == 1 && grantResults.length >= 1) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                /**
                 *当用户点击了不再提醒，就会去申请权限，然后不再提醒意味着用户没有权限，这样就会进入死循环。
                 *
                 * 在这里应该判断用户是否点击了不再提醒。怎么判断用户点击了不再提醒？如果用户拒绝了权限请求，并且不再弹出权限请求说明，那么就可以判断此时用户点击了不再提醒。
                 *
                 *  ActivityCompact.shouldShowCompact什么时候返回false?
                 *          1，第一次申请的时候
                 *          2，用户点击了不再提醒(并且此时已经拒绝了权限)
                 */
                //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "你点击了不再提醒", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
