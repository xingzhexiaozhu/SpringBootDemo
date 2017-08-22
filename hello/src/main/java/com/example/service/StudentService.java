package com.example.service;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRespository;

    public void insertTwo(){
        Student stuA = new Student();
        stuA.setSno(20111235);
        stuA.setName("HHH");
        stuA.setMajor("IS");
        studentRespository.save(stuA);

        Student stuB = new Student();
        stuB.setSno(20111238);
        stuB.setName("AAA");
        stuB.setMajor("IS");
        studentRespository.save(stuB);
    }

    /**
     * 根据学号查询学生信息
     * @param sno
     * @return
     */
    public Student findOne(Integer sno){
        return studentRespository.findOne(sno);
    }
}
