package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional(
        readOnly = false,
        timeout = 3,
        rollbackFor = Exception.class,
        isolation = Isolation.READ_COMMITTED
    )  // 添加事务，可以加到方法和类上。
    public void changeInfo() {
        studentDao.updateNameById("hello", 1);
        System.out.println("------------");
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        studentDao.updateAgeById(88, 1);
    }

}
