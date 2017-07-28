package com.bwei;

import com.bwei.mongodbLog4j.HelloController;
import com.bwei.mongodbLog4j.WebLogAspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 染熙 on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebLogAspcetTest {

    @Autowired
    private HelloController helloController;
    @Autowired
    private WebLogAspect webLogAspect;

    @Test
    public void logMongodb() {
        String 张三 = helloController.helloName("张三");

    }
}
