package springmybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmybatis/spring-mybatis-config.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.getUser(1L);
        System.out.println(user.getId()+"|"+user.getName()+"|"+user.getAge());
    }
}
