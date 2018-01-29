package com.sunny.blog.controller;

import com.sunny.blog.config.BaseTestController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunny
 * @className HelloControllerTest
 * @date 2018-01-29 18:18
 * @description:
 */
public class HelloControllerTest extends BaseTestController {
    @Autowired
    private HelloController helloController;

    @Test
    public void testHello() throws Exception {
       // HelloController controller=new HelloController();
        Assert.assertEquals("hello",helloController.hello());
    }


}
