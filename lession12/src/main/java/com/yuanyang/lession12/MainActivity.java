package com.yuanyang.lession12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 与其他应用交互
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Uri numberUri = Uri.parse("tel:4444445");
//        Intent intent = new Intent(Intent.ACTION_DIAL, numberUri);
//        //先检查系统是否具有处理此操作的应用
//        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//        if (list != null && list.size() > 0) {
//            startActivity(intent);
//        }
//
//        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
//// Or map point based on latitude/longitude
//// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//        startActivity(mapIntent);
//
//        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//        Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
//        Calendar endTime = Calendar.getInstance().set(2012, 0, 19, 10, 30);
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
//        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
//        startActivity(calendarIntent);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String title = getResources().getString(R.string.app_name);
        Intent chooser = Intent.createChooser(intent, title);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
