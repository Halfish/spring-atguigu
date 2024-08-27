package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void changeInfo() {
        changeAge();
        changeName();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge() {
        studentDao.updateAgeById(33, 1);
        int i = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName() {
        studentDao.updateNameById("haha", 1);
    }
}
