package beanPost;

import junit.framework.TestCase;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class PropertyConfigureDemoTest extends TestCase {

    public void test1(){
        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanPost/beanFactory.xml"));

        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfpp");
        SimplePostProcessor sBean = (SimplePostProcessor) bf.getBean("simpleBean");
        System.out.println(sBean.getConnectionString());
        System.out.println(sBean.getPassword());
        System.out.println(sBean.getUsername());
    }
}
