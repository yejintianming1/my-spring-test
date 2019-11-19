package lookup;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class LookUpTest {

    @Test
    public void testLookUp() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("lookup/lookupBean.xml"));
        GetBeanTest beanTest = (GetBeanTest) beanFactory.getBean("getBeanTest");
        beanTest.showMe();
    }
}
