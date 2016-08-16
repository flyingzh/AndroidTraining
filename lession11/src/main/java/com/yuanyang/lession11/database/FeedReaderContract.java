package com.yuanyang.lession11.database;

import android.provider.BaseColumns;

/**
 * Created by yuanyang on 16/8/16.
 */
public class FeedReaderContract {

    public FeedReaderContract() {
    }

    /**
     * 内部类用于定义表的名称以及列名,相当于定义的数据库的外观
     */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
