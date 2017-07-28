package com.bwei.error;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 染熙 on 2017/7/20.
 * @ControllerAdvice定义统一的异常处理类
 * @ExceptionHandler用来定义函数针对的异常类型
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MongoTemplate mongoTemplate;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String hello(HttpServletRequest req, Exception e) {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        mongoTemplate.save(r);
        return "对不起，服务繁忙";
    }
    /*
    为MyException异常创建对应的处理
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());

        mongoTemplate.save(r);
        return r;
    }

}
