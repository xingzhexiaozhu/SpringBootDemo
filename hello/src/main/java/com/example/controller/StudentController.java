package com.example.controller;

import com.example.domain.Result;
import com.example.domain.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import com.example.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRespository;

    /**
     * 查看学生列表
     * @return
     */
    @GetMapping(value="/students")
    public List<Student> studentList(){
        return studentRespository.findAll();
    }

    /**
     * 添加一个学生
//     * @param sno
//     * @param name
//     * @param major
     * @return
     */
    @PostMapping(value="/students")
//    public Student addStudent(@RequestParam("sno") Integer sno,
//                             @RequestParam("name") String name,
//                             @RequestParam("major") String major){
//        Student student = new Student();
//        student.setSno(sno);
//        student.setName(name);
//        student.setMajor(major);
//
//        return studentRespository.save(student);
//    }
//    public Student addStudent(@Valid Student student, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//        }
//
//        student.setSno(student.getSno());
//        student.setName(student.getName());
//        student.setMajor(student.getMajor());
//        return studentRespository.save(student);
//    }
    public Result<Student> addStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        student.setSno(student.getSno());
        student.setName(student.getName());
        student.setMajor(student.getMajor());

        return ResultUtil.success(studentRespository.save(student));
    }

    /**
     * 根据学号查学生
     * @param sno
     * @return
     */
    @GetMapping(value="/students/{sno}")
    public Student findStudent(@PathVariable("sno") Integer sno){
        return studentRespository.findOne(sno);
    }

    /**
     * 通过学号更新学生信息
     * @param sno
     * @param name
     * @param major
     * @return
     */
    @PutMapping(value="/students/{sno}")
    public Student updateStudent(@PathVariable("sno") Integer sno,
                                 @RequestParam("name") String name,
                                 @RequestParam("major") String major){
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setMajor(major);

        return studentRespository.save(student);
    }

    /**
     * 通过学号删除学生信息
     * @param sno
     */
    @DeleteMapping(value = "/students/{sno}")
    public void deleteStudent(@PathVariable("sno") Integer sno){
        studentRespository.delete(sno);
    }

    /**
     * 通过专业选择学生
     * @param major
     * @return
     */
    @GetMapping("/students/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable("major") String major){
        return studentRespository.findStudentsByMajor(major);
    }




    @Autowired
    StudentService studentService;

    @PostMapping("/students/addTwo")
    public void insertTwo(){
        studentService.insertTwo();
    }

}
