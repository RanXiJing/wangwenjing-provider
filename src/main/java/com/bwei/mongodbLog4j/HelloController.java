package com.bwei.mongodbLog4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 染熙 on 2017/7/20.
 */
@Controller
public class HelloController {
    /*
使用AOP统一处理Web请求日志
*/
    @RequestMapping(value = "/hel",method = RequestMethod.GET )
    @ResponseBody
    public String helloName(@RequestParam String name){
        return "RanXi"+name;
    }
}
