import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestUser {
    private SqlSession sqlSession;
    private UserMapper mapper;

    @BeforeEach
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("init");
        user.setPassword("init");
        int result = mapper.insert(user);
        System.out.println("result = " + result);
    }

    @AfterEach
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        int result = mapper.delete(1);
        System.out.println("result = " + result);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setUsername("Alice");
        user.setPassword("root");
        int result = mapper.update(user);
        System.out.println("result = " + result);
    }

    @Test
    public void testSelect() {
        User user = mapper.selectById(1);
        System.out.println("user = " + user);
    }

    @Test
    public void testSelectAll() {
        List<User> users = mapper.selectAll();
        System.out.println("users = " + users);
    }
}
