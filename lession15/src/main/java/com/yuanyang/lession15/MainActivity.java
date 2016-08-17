package com.yuanyang.lession15;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * 运行时权限
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *在Android5.1以及之前得班版本，如果你在manifest中申请了权限，会在安装得时候询问用户是否开启权限
         * 在6.0的时候，会直接返回权限拒绝。因为默认权限是拒绝的，需要动态的申请。
         */
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "has permission");
        } else if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            Log.i(TAG, "has no permission");
        }


    }
}
