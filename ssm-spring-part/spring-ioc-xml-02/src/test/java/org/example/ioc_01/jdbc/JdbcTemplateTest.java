package org.example.ioc_01.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.ioc_01.controller.StudentController;
import org.example.ioc_01.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {

    /*
     * JdbcTemplate 只简化数据库的 crud，不提供连接池
     * DruidDataSource 负责链接的创建和数据库驱动的注册等
     */
    @Test
    public void testForJava() {

        // 创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.9.222:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("admin");
        dataSource.setPassword("sentPass123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 查询单个对象
        //jdbcTemplate.queryForObject()

        // 查询集合
        String sql = "select id, name, gender, age, class as classes from students;";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("Students: " + students);
    }

    /*
     * 通过 IoC 容器读取 JdbcTemplate 组件
     */
    @Test
    public void testForIoC() {
        // 从 IoC 容器中读取 JdbcTemplate 组件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        System.out.println(template);

        // 插入数据
        String sql = "insert into students (name, gender, age, class) values (?, ?, ?, ?);";
//        int rows = template.update(sql,  "二狗子", "男", 18, "三年二班");
//        System.out.println(rows);

        // 查询数据
        sql = "select * from students where id = ?;";
        template.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);

        // 查询所有学生数据
        sql = "select id, name, gender, age, class as classes from students;";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("Students: " + students);
    }

    /*
     * 从 IoC 容器中获取 controller
     */
    @Test
    public void testQueryAll() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
        context.close();
    }
}
