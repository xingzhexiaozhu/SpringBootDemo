package com.example.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 利用AOP技术对往数据库中插入学生信息作权限验证
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //@Before的注解在方法执行之前执行
    //拦截该路径下studentList()方法，两个点表示任何参数
//    @Before("execution(public * com.example.controller.StudentController.studentList(..))")
//    public void log(){
//        System.out.println("Test before");
//    }
//
//    @After("execution(public * com.example.controller.StudentController.studentList(..))")
//    public void doAfter(){
//        System.out.println("Test after");
//    }

    //定义一个公用方法
    @Pointcut("execution(public * com.example.controller.StudentController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURI());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //method
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //param
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
    }

    @AfterReturning(returning="obj", pointcut = "log()")
    public void doAfterReturnig(Object obj){
        logger.info("reponse={}", obj);
    }
}
