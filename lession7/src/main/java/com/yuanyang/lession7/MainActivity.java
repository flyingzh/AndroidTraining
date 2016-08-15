package com.yuanyang.lession7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 用Fragment构建灵活的界面
 */
public class MainActivity extends AppCompatActivity {


    //在onCreate中完成初始Fragment的添加
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFragment fragment = new MyFragment();
        /**
         * addToBackStack参数作为操作名，可以为null。无实际意义
         */
        getSupportFragmentManager().beginTransaction().add(R.id.contailer, fragment).addToBackStack("myFragment").commit();
        //getSupportFragmentManager().beginTransaction().add(R.id.contailer, fragment).commit();

    }
}
