package utils;

import junit.framework.TestCase;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntPathMatcherTest extends TestCase {

    public void test() {
        PathMatcher pathMatcher = new AntPathMatcher();
        String combine = pathMatcher.combine("D:/devsoft", "/git");
        System.out.println("组合后的路径："+combine);

        boolean pattern = pathMatcher.isPattern("D:/devsoft/*");
        System.out.println("是否模式："+pattern);

        boolean match = pathMatcher.match("D:/devsoft/**", "D:/devsoft/git/e");
        System.out.println("是否匹配："+match);

    }
}
