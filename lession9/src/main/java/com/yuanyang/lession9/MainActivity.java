package com.yuanyang.lession9;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * getSharedPreference和getPreference的用法
 */
public class MainActivity extends FragmentActivity {

    private String name_sharepreference = this.getClass().getSimpleName();

    private String key_istest = "isTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSharedPreferences(name_sharepreference, MODE_PRIVATE).edit().putString(key_istest, "hello").apply();
        Toast.makeText(this, getPreferences(MODE_PRIVATE).getString(key_istest, "world"), Toast.LENGTH_SHORT).show();
    }
}
