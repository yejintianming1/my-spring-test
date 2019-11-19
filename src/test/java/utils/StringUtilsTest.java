package utils;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringUtilsTest extends TestCase {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("b");
        list.add("d3");
        String[] strArr = StringUtils.toStringArray(list);
        String[] strings = list.toArray(new String[0]);
        for (String s: strings) {
            System.out.println(s);
        }
//        for (String s: strArr) {
//            System.out.println(s);
//        }
    }
}
