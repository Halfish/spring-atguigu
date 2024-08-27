package org.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int updateNameById(String name, Integer id) {
        String sql = "update students set name = ? where id = ?";
        int rows = jdbcTemplate.update(sql, name, id);
        return rows;
    }

    public int updateAgeById(Integer age, Integer id) {
        String sql = "update students set age = ? where id = ?";
        int rows = jdbcTemplate.update(sql, age, id);
        return rows;
    }
}
