import com.atguigu.ioc_01.HappyComponent;
import com.atguigu.ioc_03.JavaBean;
import com.atguigu.ioc_04.JavaBeanName;
import com.atguigu.ioc_04.JavaBeanFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    @Test
    public void test01() {
        // 创建 Ioc 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_01.xml");

        // 读取 IOC 容器里的组件
        HappyComponent happyComponent = applicationContext.getBean("happyComponent", HappyComponent.class);
        happyComponent.doWork();
    }

    @Test
    public void test03() {
        // 测试 IOC 的初始化和销毁方法
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_03.xml");

        // 单例模式的实例化
        JavaBean bean1 = applicationContext.getBean("javaBeanSingle", JavaBean.class);
        JavaBean bean2 = applicationContext.getBean("javaBeanSingle", JavaBean.class);
        System.out.println(bean1 == bean2);

        // 调用 clear
        applicationContext.close();
    }

    @Test
    public void test04() {
       ApplicationContext context = new ClassPathXmlApplicationContext("ioc_04.xml") ;
       JavaBeanName bean = context.getBean("javaBean", JavaBeanName.class);
       System.out.println(bean.getName());

       // 也可以得到工厂类
       JavaBeanFactoryBean factoryBean = context.getBean("&javaBean", JavaBeanFactoryBean.class);
       try {
           JavaBeanName name = factoryBean.getObject();
           System.out.println(name.getName());
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
