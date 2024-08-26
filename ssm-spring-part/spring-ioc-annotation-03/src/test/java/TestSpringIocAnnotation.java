import org.example.ioc_01.MyController;
import org.example.ioc_01.MyDao;
import org.example.ioc_01.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIocAnnotation {

    @Test
    public void testIoc01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        MyDao dao = context.getBean(MyDao.class);
        System.out.println("Get Dao: " + dao);

        MyService service = context.getBean(MyService.class);
        System.out.println("Get Service: " + service);

        // 被排除了，找不到
//        MyController controller = context.getBean(MyController.class);
//        System.out.println("Get Controller: " + controller);
        context.close();
    }
}
