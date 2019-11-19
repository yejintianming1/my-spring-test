package constructorargs;

import contructorargs.HelloBean;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ConstructorArgsTest extends TestCase {

    @Test
    public void testConstructorArgs() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("constructorargs/Contructorargs.xml"));
        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        System.out.println(helloBean);
    }
}
