package com.yuanyang.lession11;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yuanyang.lession11.database.FeedReaderContract;
import com.yuanyang.lession11.database.FeedReaderDbHelper;

/**
 * 在SQL数据库中保存数据
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FeedReaderDbHelper helper = new FeedReaderDbHelper(this);
        //new Thread(new InsertTask(helper)).start();
        //new Thread(new GetDataTask(helper)).start();
        new Thread(new DeleteTask(helper)).start();
    }

    class InsertTask implements Runnable {

        private FeedReaderDbHelper helper;

        public InsertTask(FeedReaderDbHelper helper) {
            this.helper = helper;
        }

        @Override
        public void run() {
            if (helper != null) {
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, "first");
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "盗墓笔记");
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "盗墓笔记1111111");
                helper.getWritableDatabase().insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
                Log.i(TAG, "insert success");
            }
        }
    }

    class GetDataTask implements Runnable {

        private FeedReaderDbHelper helper;

        public GetDataTask(FeedReaderDbHelper helper) {
            this.helper = helper;
        }

        @Override
        public void run() {
            if (helper != null) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String[] projection = {
                        FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
                };
                Cursor cursor = db.query(FeedReaderContract.FeedEntry.TABLE_NAME,
                        projection,
                        null,
                        null,
                        null,
                        null,
                        null
                );
                while (cursor.moveToNext()) {
                    Log.i(TAG, cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE)));
                }
                Log.i(TAG, "success");

            }
        }
    }

    class DeleteTask implements Runnable {

        private FeedReaderDbHelper helper;

        public DeleteTask(FeedReaderDbHelper helper) {
            this.helper = helper;
        }

        @Override
        public void run() {
            SQLiteDatabase db = helper.getWritableDatabase();
            String whereCluse = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " like ?";
            String[] whereArgs = {"first"};
            int code = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, whereCluse, whereArgs);
            Log.i(TAG, code + "");
        }
    }


}
