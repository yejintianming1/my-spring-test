package jdkDynamicProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void testProxy() {
        Say person = new Person();
        Say say = (Say) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Say.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String result = (String) method.invoke(person, args);
                return result;
            }
        });
        say.say("说话是一门艺术");
        System.out.println("aaa");
    }
}
