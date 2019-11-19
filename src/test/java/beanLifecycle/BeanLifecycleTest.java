package beanLifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanLifecycle/applicationContext.xml");
        Man man=(Man)context.getBean("man");
        man.run();
        context.close();
    }
}
