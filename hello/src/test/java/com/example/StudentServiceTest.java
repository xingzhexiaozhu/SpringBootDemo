package com.example;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表示在测试环境
@RunWith(SpringRunner.class)
//该注解启动整个Spring-Boot应用程序
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void fineOneTest(){
        Student student = studentService.findOne(20110002);
//        Assert.assertEquals("English", student.getMajor());
        Assert.assertEquals("Test11", student.getName());
    }
}
