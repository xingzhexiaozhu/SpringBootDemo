package com.example.repository;

import com.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    //通过major来选择学生
    public List<Student> findStudentsByMajor(String major);
}
