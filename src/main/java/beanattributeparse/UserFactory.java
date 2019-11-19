package beanattributeparse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class UserFactory {

    public static User getUser() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanattributeparse/AttributeParseTest.xml"));
        return (User) beanFactory.getBean("user");
    }
}
