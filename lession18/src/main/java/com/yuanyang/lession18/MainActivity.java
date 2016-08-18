package com.yuanyang.lession18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_item_share);
        shareActionProvide = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "hello,this is a auful website :www.baidu.com");
        Intent chooser = Intent.createChooser(intent, "像其他应用发送文本数据");
        if (shareActionProvide != null) {
            shareActionProvide.setShareIntent(intent);
        }
        return true;
    }
}
