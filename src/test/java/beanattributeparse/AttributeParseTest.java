package beanattributeparse;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class AttributeParseTest extends TestCase {

    @Test
    public void testBeanScope() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanattributeparse/AttributeParseTest.xml"));
        User user = (User) beanFactory.getBean("user");
        User user1 = (User) beanFactory.getBean("user");
        user.setName("name4");
        System.out.println("user="+user.getName());
        System.out.println("user1="+user1.getName());
        System.out.println();
    }

    @Test
    public void testBeanAutowire() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanattributeparse/AttributeParseTest.xml"));
        User user = (User) beanFactory.getBean("user");
        System.out.println("province="+user.getAddress().getProvince());
        System.out.println("addr="+user.getAddress().getAddr());
    }

    @Test
    public void testBeanFactoryMethod() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanattributeparse/AttributeParseTest.xml"));
        User user = (User) beanFactory.getBean("userFactory");
        System.out.println(user.getName());
        System.out.println(user.getAddress().getAddr());
    }

    @Test
    public void testBeanDefaultName() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanattributeparse/AttributeParseTest.xml"));
        User user = (User) beanFactory.getBean("beanattributeparse.User");
        System.out.println(user.getName());

    }
}
