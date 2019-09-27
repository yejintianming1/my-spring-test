package beanutils;

import junit.framework.TestCase;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PersonUtilsTest extends TestCase {

    public void test() {
        User u = new User();
        u.setName("xiaoming");
        u.setPassword("123");
        u.setAge(32);
        u.setCreateTime(new Date());
//        Person p = new Person();
        Person p = BeanUtils.instantiateClass(Person.class);
        BeanUtils.copyProperties(u,p,"password");

        System.out.println(p);
    }

}
