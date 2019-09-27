package customtag;

import junit.framework.TestCase;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoaderTest extends TestCase {

    public void test1() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("META-INF/spring.handlers", Thread.currentThread().getContextClassLoader());
            System.out.println(properties.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
