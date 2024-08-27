import com.atguigu.advice.LogAdvice;
import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value= JavaConfig.class)
public class TestAOP {

    @Autowired
    private Calculator calculator;

    @Autowired
    private LogAdvice advice;

    @Test
    public void testAOP_01() {
        int result = calculator.add(9, 8);
        System.out.println("result = " + result);

        System.out.println("advice = " + advice);
    }
}
