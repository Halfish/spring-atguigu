import com.atguigu.ioc_01.MyDao;
import com.atguigu.ioc_01.MyService;
import com.atguigu.ioc_02.JavaBean;
import com.atguigu.ioc_03.UserController;
import com.atguigu.ioc_04.NewJavaBean;
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

    @Test
    public void test02() {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
       JavaBean bean = context.getBean(JavaBean.class);
       JavaBean bean2 = context.getBean(JavaBean.class);
       System.out.println(bean);
       System.out.println(bean2);
       System.out.println(bean == bean2);
       context.close();
    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController controller = context.getBean(UserController.class);
        controller.show();
    }

    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        NewJavaBean bean = context.getBean(NewJavaBean.class);
        System.out.println(bean);
    }
}
