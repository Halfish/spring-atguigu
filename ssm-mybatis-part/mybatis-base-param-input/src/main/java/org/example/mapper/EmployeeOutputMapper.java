package org.example.mapper;

import org.example.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeOutputMapper {
    int deleteById(Integer id);
    Employee queryById(Integer id);
    String queryNameById(Integer id);
    Double querySalaryByName(String name);

    // 查询部门的最高工资和平均工资
    Map<String, Object> selectEmpNameAndMaxSalary();

    // 查询工资高于某个值的员工名
    List<String> queryNamesBySalary(Double salary);

    // 查询所有员工
    List<Employee> queryAll();

    int insertEmp(Employee employee);
}
