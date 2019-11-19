package beanLifecycle;

public class ReadMe {

    /**
     * spring 容器中的bean的完整生命周期一共分为十一步完成。
     *
     * 1.bean对象的实例化
     *
     * 2.封装属性，也就是设置properties中的属性值
     *
     * 3.如果bean实现了BeanNameAware，则执行setBeanName方法,也就是bean中的id值
     *
     * 4.如果实现BeanFactoryAware或者ApplicationContextAware ，需要设置setBeanFactory或者上下文对象setApplicationContext
     *
     * 5.如果存在类实现BeanPostProcessor后处理bean，执行postProcessBeforeInitialization，可以在初始化之前执行一些方法
     *
     * 6.如果bean实现了InitializingBean，则执行afterPropertiesSet，执行属性设置之后的操作
     *
     * 7.调用<bean　init-method="">执行指定的初始化方法
     *
     * 8.如果存在类实现BeanPostProcessor则执行postProcessAfterInitialization，执行初始化之后的操作
     *
     * 9.执行自身的业务方法
     *
     * 10.如果bean实现了DisposableBean，则执行spring的的销毁方法
     *
     * 11.调用<bean　destory-method="">执行自定义的销毁方法。
     *
     * 第五步和第八步可以结合aop，在初始化执行之前或者执行之后执行一些操作。
     *
     * 以上就是springbean的完整生命周期.
     */
}
