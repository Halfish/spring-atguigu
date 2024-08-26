package org.example.ioc_01.controller;

import org.example.ioc_01.pojo.Student;
import org.example.ioc_01.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println("studentController: " + students);
    }
}
