import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmployeeMapper;
import org.example.mapper.TeacherMapper;
import org.example.pojo.Employee;
import org.example.pojo.Teacher;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisTest {

    @Test
    public void testMyBatis() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.queryById(1);
        System.out.println("Employee = " + employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testTeacher() throws IOException {
        // 测试自动生成 uuid 作为主键
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.settName("Alice");
        teacherMapper.insertOne(teacher);
//        sqlSession.commit();
        sqlSession.close();
    }
}
