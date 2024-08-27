import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring.xml")
public class SpringAOPTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(9, 8);
        System.out.println("result = " + result);
    }
}
