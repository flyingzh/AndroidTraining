package com.yuanyang.lession19;

import android.content.Context;

/**
 * Created by yuanyang on 16/8/18.
 */
public class ClassUnderTest {

    Context context;

    public ClassUnderTest(Context context) {
        this.context = context;
    }

    public String getHelloWorldString() {
        return context.getString(R.string.app_name);
    }
}
