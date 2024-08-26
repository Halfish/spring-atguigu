package org.example.ioc_01.dao;

import org.example.ioc_01.pojo.Student;

import java.util.List;

public interface StudentDao {
   List<Student> queryAll();
}
