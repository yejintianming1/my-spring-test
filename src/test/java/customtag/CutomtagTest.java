package customtag;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class CutomtagTest extends TestCase {

    @Test
    public void testUser() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("customtag/Customtag.xml");
        User user = (User) bf.getBean("testBean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }

    @Test
    public void test2() {
        String addr = "上海市青浦区明珠路1018号";
//        if (addr.contains("上海市")) {
//            System.out.println(addr.indexOf("上海市"));
//            System.out.println("上海市".length());
//            System.out.println(addr.indexOf("上海市")+"上海市".length());
//            addr = addr.substring(addr.indexOf("上海市")+"上海市".length());
//            System.out.println(addr);
//        }
        String subStr = "null";
        String s = subTargetStr(addr, subStr);
        System.out.println(addr);
        System.out.println(s);


    }

    private String subTargetStr(String originStr, String subStr) {
        if (!StringUtils.hasText(originStr) || !StringUtils.hasText(subStr)) {
            return originStr;
        }
        Integer begin = originStr.indexOf(subStr);
        if (begin != -1) {
            originStr = originStr.substring(begin+subStr.length());
        }
        return originStr;
    }
}
