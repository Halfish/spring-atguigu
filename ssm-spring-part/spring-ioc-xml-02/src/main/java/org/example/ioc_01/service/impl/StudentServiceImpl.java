package org.example.ioc_01.service.impl;

import org.example.ioc_01.dao.StudentDao;
import org.example.ioc_01.pojo.Student;
import org.example.ioc_01.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.queryAll();
        System.out.println("studentService: " + students);
        return students;
    }
}
