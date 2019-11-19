package utils;

import junit.framework.TestCase;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

import java.util.UUID;

public class AlternativeJdkIdGeneratorTest extends TestCase {


    public void test() {
        IdGenerator idGenerator = new AlternativeJdkIdGenerator();
        UUID uuid = idGenerator.generateId();
        System.out.println("spring uuid:"+uuid.toString());

        UUID uuid1 = UUID.randomUUID();
        System.out.println("   jdk uuid:"+uuid1.toString());
    }
}
