package com.example.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {
    private final static Logger logger = LoggerFactory.getLogger(HelloAspect.class);

    @Autowired
    HelloAspect helloAspect;

    @RequestMapping("/statistic")
    public String getStatisticTime(){
        return helloAspect.doAfterReturning("测试");
    }
}
