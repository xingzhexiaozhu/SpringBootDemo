package com.example.aopdemo.newMethod;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    @InvokeTimeCount
    public String getStr(String param){
        return param;
    }

}
