package com.yuanyang.lession19;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by yuanyang on 16/8/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailValidatorTest {

    @Test
    public void testIsEmail() throws Exception {

        Assert.assertFalse(EmailValidator.isEmail("sss"));
    }
}