package com.example.controller;

import com.example.properties.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private PeopleProperties peo;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")  //PostMapping
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myID){
//        return peo.getName() + "\t" + peo.getAge();
        return "id: " + myID;
    }
}
