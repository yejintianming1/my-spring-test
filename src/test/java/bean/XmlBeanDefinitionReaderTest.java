package bean;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;

public class XmlBeanDefinitionReaderTest extends TestCase {

    @Test
    public void testInstantiateDocumentReaderClass() {
        DefaultBeanDefinitionDocumentReader docReader = BeanUtils.instantiateClass(DefaultBeanDefinitionDocumentReader.class);
        System.out.println(docReader);
    }
}
