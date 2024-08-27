package com.atguigu.ioc_01.dao;

import com.atguigu.ioc_01.pojo.Student;

import java.util.List;

public interface StudentDao {
   List<Student> queryAll();
}
