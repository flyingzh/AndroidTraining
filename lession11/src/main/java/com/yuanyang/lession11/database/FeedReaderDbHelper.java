package com.yuanyang.lession11.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yuanyang on 16/8/16.
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "feedback.db";
    private static final int DATABASE_VERSION = 4;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    //创建数据库的语句
    private static final String SQL_CREATE_ENTRIES = "create table " + FeedReaderContract.FeedEntry.TABLE_NAME + "(" +
            FeedReaderContract.FeedEntry._ID + " integer primary key," +
            FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
            FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE +
            ")";

    private static final String SQL_DELETE_ENTRIES = "drop table if exists " + FeedReaderContract.FeedEntry.TABLE_NAME;
    private static final String TAG = "FeedReaderDbHelper";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
