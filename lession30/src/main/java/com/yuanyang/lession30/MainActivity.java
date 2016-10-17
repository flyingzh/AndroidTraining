package com.yuanyang.lession30;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showSnackBar(View v) {
        Snackbar snackbar = Snackbar.make(v, "snackBar", Snackbar.LENGTH_SHORT);
        snackbar.setAction("action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("hello", "hello");
            }
        }).show();

    }
}
