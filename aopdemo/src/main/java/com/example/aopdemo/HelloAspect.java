package com.example.aopdemo;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class HelloAspect {
    private final static Logger logger = LoggerFactory.getLogger(HelloAspect.class);

    StatisticFunction statistic;

//    @Pointcut("execution(public * com.example.aopdemo.HelloController.say())")
//    @Pointcut(value = "execution(public * com.example.aopdemo.HelloController.sayParam(..)) && args(param)", argNames = "param")
//    public void log(String param){}

//    @Before("log()")
    @Before(value = "execution(public * com.example.aopdemo.HelloController.sayParam(..)) && args(param)", argNames = "param")
    public void doBefore(String param){
        statistic.exeCount++;
        statistic.exeStartTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        logger.info("doBefore hello : " + param + simpleDateFormat.format(statistic.exeStartTime));
    }

//    @After("log()")
    @After(value = "execution(public * com.example.aopdemo.HelloController.sayParam(..)) && args(param)", argNames = "param")
    public void doAfter(String param){
        statistic.exeEndTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        logger.info("doAfter hello : " + param + simpleDateFormat.format(statistic.exeEndTime));
    }

//    @AfterReturning("log()")
    @AfterReturning(value = "execution(public * com.example.aopdemo.HelloController.sayParam(..)) && args(param)", argNames = "param")
    public String doAfterReturning(String param){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        logger.info("doAfterReturning hello : " + param + simpleDateFormat.format(date));

        statistic.exeTime = (statistic.exeEndTime - statistic.exeStartTime);
        logger.info(statistic.exeEndTime + "\t" + statistic.exeStartTime + "\t" + statistic.exeTime);
        return "StatisticCount: " + statistic.exeCount + "\tStatisticTime: " + statistic.exeTime;
    }
}
