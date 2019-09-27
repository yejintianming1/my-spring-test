package aop;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJBeanTest extends TestCase {

    @Test
    public void test() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aop/AspectJ.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }
}
