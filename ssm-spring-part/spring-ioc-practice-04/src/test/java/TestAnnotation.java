import com.atguigu.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    @Test
    public void testController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
    }
}
