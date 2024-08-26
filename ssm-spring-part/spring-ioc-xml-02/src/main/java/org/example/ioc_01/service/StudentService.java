package org.example.ioc_01.service;

import org.example.ioc_01.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
}
