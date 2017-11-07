package com.example.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloAspect.class);

    @RequestMapping("/hello")
    public String say() throws InterruptedException {
        Thread.sleep(300);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        logger.info("hello : " + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }

    @RequestMapping("/hello/param")
    public String sayParam(@RequestParam String param) throws InterruptedException {
        Thread.sleep(300);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        logger.info(param + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }
}
