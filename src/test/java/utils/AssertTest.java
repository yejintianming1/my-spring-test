package utils;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest extends TestCase {

    @Test
    public void test() {
        String a = null;
        Assert.notNull(a,"a为null");
    }
}
