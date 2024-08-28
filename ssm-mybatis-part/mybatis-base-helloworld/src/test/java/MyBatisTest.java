import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.example.pojo.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    /*
     * 通过 MyBatis 提供的 API，进行方法的调用。
     */
    @Test
    public void testXml() throws IOException {
        // 1. 读取外部配置文件 （mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 创建 sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3. 创建 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 获取接口的代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);

        // 5. 提交事务、释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_ibatis() throws IOException {
        // 1. 读取外部配置文件 （mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 创建 sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3. 创建 session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 获取接口的代理对象
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = mapper.queryById(1);
//        System.out.println("employee = " + employee);
        Student student = sqlSession.selectOne("org.namespace.findStudent", 1);
        // 缺点：1. statement 容易出错；2.只能有一个参数；3.返回值类型没有指定
        // 所以 mybatis 比 ibatis 就多了个接口定义
        System.out.println("student = " + student);

        // 5. 提交事务、释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
