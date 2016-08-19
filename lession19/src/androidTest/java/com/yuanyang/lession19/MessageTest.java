package com.yuanyang.lession19;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by yuanyang on 16/8/19.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MessageTest {

    public static final String content = "this is test";
    public static final String time = "2016819";
    public static final int count = 10;

    private Message message;


    @Before
    public void createMessage() {
        message = new Message();
    }


    @Test
    public void testMessageWriteRead() {
        message.setContent(content);
        Parcel parcel = Parcel.obtain();
        message.writeToParcel(parcel, message.describeContents());
        //在写完之后，要重置Parcel
        parcel.setDataPosition(0);

        Message msg = Message.CREATOR.createFromParcel(parcel);

        //assertThat(message.getContent(), is(content));
        Assert.assertEquals(content, msg.getContent());

    }


}