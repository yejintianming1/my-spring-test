package replacedmethod;

import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ReplacedMethodTest extends TestCase {

    public void testReplacedMethod() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("replacedmethod/replacedMethod.xml"));
        ChangeMethod changeMethod = (ChangeMethod) beanFactory.getBean("changeMethod");
        changeMethod.changeMe();
    }
}
