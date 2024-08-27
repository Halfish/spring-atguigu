package com.atguigu.service;

import com.atguigu.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void findAll() {
        studentDao.findAll();
    }
}
