package com.yuanyang.lession10;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_data = (TextView) findViewById(R.id.tv_data);
        File file = getFilesDir();//获取内部存储
        tv_data.append(file.toString() + "\n");
        tv_data.append(file.isDirectory() ? "目录" + file.listFiles().length : "文件");
        tv_data.append("\n");
        for (File f : file.listFiles()) {
            tv_data.append("  " + f.toString() + "\n");
        }
        File cacheFile = getCacheDir();
        tv_data.append(cacheFile.toString() + "\n");
//        for (File f : cacheFile.listFiles()) {
//            tv_data.append("  " + f.toString() + "\n");
//        }

        tv_data.append(getExternalCacheDir().toString() + "\n");//返回从此应用的外部缓存存储
        //tv_data.append(getExternalCacheDirs().toString() + "\n");
        for (File f : getExternalCacheDirs()) {
            if (f != null) {
                tv_data.append("外部缓存：" + f.toString() + "\n");
            }
        }
        tv_data.append(getCodeCacheDir().toString() + "\n");

        File dcimFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        tv_data.append(dcimFile.toString() + dcimFile.listFiles().length + "\n");
        for (File f : dcimFile.listFiles()) {
            tv_data.append(f.toString() + "\n");
        }

        File musicFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        for (File f : musicFile.listFiles()) {
            tv_data.append(f.toString() + "\n");
        }
        tv_data.append(Environment.getRootDirectory().toString() + "\n");
        tv_data.append((Environment.isExternalStorageEmulated() ? "enum" : "not enum") + "\n");
        tv_data.append((Environment.isExternalStorageRemovable() ? "removeable" : "not removeable") + "\n");
        tv_data.append(Environment.getDownloadCacheDirectory().toString() + "\n");
        tv_data.append(Environment.getExternalStorageDirectory().toString() + "\n");
    }
}
