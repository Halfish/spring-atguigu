import org.example.Calculator;
import org.example.CalculatorPureImpl;
import org.example.dynamics.ProxyFactory;
import org.example.statics.StaticProxyCalculator;
import org.junit.Test;

public class TestProxy {

    @Test
    public void testStaticProxy() {
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        StaticProxyCalculator calculator = new StaticProxyCalculator(calculatorPure);
        calculator.add(8, 9);
    }

    @Test
    public void testJDKProxy() {
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        ProxyFactory factory = new ProxyFactory(calculatorPure);
        Calculator proxy = (Calculator) factory.getProxy();
//        System.out.println("proxy = " + proxy);
        proxy.add(9, 10);
    }
}
