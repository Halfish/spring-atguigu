package org.example.mapper;

import org.example.pojo.Employee;

public interface EmployeeMapper {
    Employee queryById(Integer id);
    void deleteById(Integer id);
}
