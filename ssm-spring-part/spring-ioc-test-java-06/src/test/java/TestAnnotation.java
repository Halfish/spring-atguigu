import org.example.components.ClassA;
import org.example.components.ClassB;
import org.example.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@SpringJUnitConfig(locations = "指定配置xml文件", value = 指定配置类)
@SpringJUnitConfig(value = {JavaConfig.class})
public class TestAnnotation {

    @Autowired
    private ClassA classA;

    @Autowired
    private ClassB classB;

    @Test
    public void test() {
        classA.hello();
        classB.hello();
    }

    @Test
    public void testJava() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ClassA classA1 = context.getBean(ClassA.class);
        classA1.hello();
    }
}
