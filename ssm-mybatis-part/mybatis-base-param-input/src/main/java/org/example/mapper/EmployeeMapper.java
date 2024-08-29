package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;
import org.example.pojo.Employee;

import java.util.List;
import java.util.Map;

@Alias("ergouzi")   // 别名
public interface EmployeeMapper {
    Employee queryById(Integer id);
    void deleteById(Integer id);
    List<Employee> queryBySalary(Double salary);
    int insertEmp(Employee employee);
    List<Employee> queryByNameAndSalary(@Param("a") String name, @Param("b") Double salary);
    int insertEmpMap(Map<String, String> map);
}
