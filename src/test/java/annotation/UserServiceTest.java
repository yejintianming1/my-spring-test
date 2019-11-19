package annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {


    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation/bean.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        User user = userService.queryUserById("1");
        System.out.println(user);
    }
}
