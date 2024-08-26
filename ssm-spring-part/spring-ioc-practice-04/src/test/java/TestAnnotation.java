import org.example.controller.StudentController;
import org.example.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAnnotation {

    @Test
    public void testController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
    }
}
