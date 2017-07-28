package com.bwei.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 染熙 on 2017/7/20.
 */
@Controller
public class ExceptionController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        int e =1/0;
        return "发生错误e";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

}
