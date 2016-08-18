package com.yuanyang.lession19;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by yuanyang on 16/8/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTestDemo {

    private static final String FAKE_STRING = "hello_world";
    @Mock
    private Context mMockContext;


    @Test
    public void readStringFromContext_LocalizedString() {

        //当调用context.getString方法以后，就返回参数
        when(mMockContext.getString(R.string.app_name)).thenReturn(FAKE_STRING);

        ClassUnderTest test = new ClassUnderTest(mMockContext);
        String helloWorldString = test.getHelloWorldString();
        assertThat(helloWorldString, is(FAKE_STRING));
    }


}
