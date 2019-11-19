package beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcess implements BeanPostProcessor {

    //后处理bean，最重要的两步
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("第五步：初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("第八步：执行初始化之后的方法");
        return bean;
    }
}