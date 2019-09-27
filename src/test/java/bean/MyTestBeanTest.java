package bean;

import junit.framework.TestCase;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.xml.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class MyTestBeanTest extends TestCase {

    @Test
    public void test() {
        String str = " xida  o小 王 ";
        System.out.println(str.replaceAll("\\s*",""));
    }



    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean/MyTestBean.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr",bean.getTestStr());
    }

    @Test
    public void testSimpleLoad3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/MyTestBean.xml");
        MyTestBean bean = (MyTestBean) context.getBean("myTestBean");
        assertEquals("testStr",bean.getTestStr());
    }


    @Test
    public void testSimpleLoad2() {
        //1.通过classLoader加载资源
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean/MyTestBean.xml");
        //2.使用SAX解析XML文档
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage","http://www.w3.org/2001/XMLSchema");
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        documentBuilder.setEntityResolver(new ResourceEntityResolver(new PathMatchingResourcePatternResolver()));
        documentBuilder.setErrorHandler(new SimpleSaxErrorHandler(LogFactory.getLog(getClass())));
        Document doc = null;
        try {
            doc = documentBuilder.parse(new InputSource(inputStream));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element root = doc.getDocumentElement();
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                if (isDefaultNamespace(ele)) {
                    // TODO 默认标签解析
                } else {
                    // TODO 自定义标签解析
                }
            }
        }


        Node rNode = root;
        String namespaceURI = rNode.getNamespaceURI();
        System.out.println(namespaceURI);
        if (!StringUtils.hasLength(namespaceURI) || "http://www.springframework.org/schema/beans".equals(namespaceURI)) {
            //没有namespaceURI或者namespaceURI是http://www.springframework.org/schema/beans时，则认为是默认的namespace
            System.out.println("该node is default namespace");
        }

//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean/MyTestBean.xml"));
//        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
//        assertEquals("testStr",bean.getTestStr());
    }

    private boolean isDefaultNamespace(Node node) {
        if (!StringUtils.hasLength(node.getNamespaceURI()) || "http://www.springframework.org/schema/beans".equals(node.getNamespaceURI())) {
            //没有namespaceURI或者namespaceURI是http://www.springframework.org/schema/beans时，则认为是默认的namespace
            return true;
        }
        return false;
    }


}
