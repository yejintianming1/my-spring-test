package factoryBean;

import beanPostProcessor.MyBeanPostProcessor;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class CarFactoryBeanTest extends TestCase {

    public void test() {
        BeanFactory bf = new ClassPathXmlApplicationContext("factoryBean/carFactoryBean.xml");
        Car car = (Car) bf.getBean("car");
        CarFactoryBean carFactoryBean = (CarFactoryBean) bf.getBean("&car");
        try {
            System.out.println(carFactoryBean.getCarInfo() + carFactoryBean.getObject().toString() + carFactoryBean.getObjectType().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(car.getBrand() + car.getPrice() + car.getMaxSpeed());
    }

    public void test1() {
        AbstractAutowireCapableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("factoryBean/carFactoryBean.xml"));
        MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor) bf.getBean("myBeanPostProcessor");
        bf.addBeanPostProcessor(myBeanPostProcessor);
        Car car = (Car) bf.getBean("car");
        CarFactoryBean carFactoryBean = (CarFactoryBean) bf.getBean("&car");
        try {
            System.out.println(carFactoryBean.getCarInfo() + carFactoryBean.getObject().toString() + carFactoryBean.getObjectType().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(car.getBrand() + car.getPrice() + car.getMaxSpeed());
    }


}
