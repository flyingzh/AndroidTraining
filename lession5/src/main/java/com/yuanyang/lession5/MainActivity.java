package com.yuanyang.lession5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止方法信息记录
        android.os.Debug.stopMethodTracing();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /**
         * 只有Activity从停止状态到运行状态时才会回调该方法
         */
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * 失去焦点，但是至少部分可见
         */
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * 在这里可以执行CPU密集型计算，比如更新数据库，保存用户数据等。
         */
    }
}
