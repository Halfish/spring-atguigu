import com.alibaba.druid.pool.DruidDataSource;
import org.example.config.JavaConfiguration;
import org.example.ioc_01.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringIoC {
    @Test
    public void test() {
        // 创建 IoC 容器
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController controller = context.getBean(StudentController.class);
        controller.ping();

        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }
}
