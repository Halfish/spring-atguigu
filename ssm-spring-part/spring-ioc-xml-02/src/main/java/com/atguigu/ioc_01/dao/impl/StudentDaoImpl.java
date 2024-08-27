package com.atguigu.ioc_01.dao.impl;

import com.atguigu.ioc_01.dao.StudentDao;
import com.atguigu.ioc_01.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        // 数据库查询
        String sql = "select id, name, gender, age, class as classes from students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentDao: " + students);
        return List.of();
    }
}
