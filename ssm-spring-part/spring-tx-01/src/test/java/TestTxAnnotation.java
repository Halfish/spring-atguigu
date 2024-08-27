import org.example.config.JavaConfig;
import org.example.service.StudentService;
import org.example.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class TestTxAnnotation {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void testTx() {
        studentService.changeInfo();
    }

    @Test
    public void testTop() {
        topService.changeInfo();
    }
}
