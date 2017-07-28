package com.bwei.mongodbLog4j;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by 染熙 on 2017/7/20.
 * Web层日志切面
 */
@Aspect
@Component
public class WebLogAspect {

    private org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    @Pointcut("execution(public * com.bwei.mongodbLog4j..*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        Logger log=new Logger();
        log.setUrl(request.getRequestURL().toString());
        log.setHttp_method(request.getMethod());
        log.setIp(request.getRemoteAddr());
        log.setClass_method(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.setArgs(Arrays.toString(joinPoint.getArgs()));
        mongoTemplate.save(log);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

}
