package parsexml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class LoadDocumentTest {

    @Test
    public void test() throws IOException, ParserConfigurationException, SAXException {
        //1.读取指定位置的XML文件
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("");//classpath
        InputSource inputSource = new InputSource(inputStream);

        //2.创建DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        int validationMode = 2;//2是dtd,3是xsd
        factory.setNamespaceAware(false);
        if (validationMode == 3) {
            factory.setNamespaceAware(true);
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage","http://www.w3.org/2001/XMLSchema");
        }

        //3.创建DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        EntityResolver entityResolver = null;
        ErrorHandler errorHandler = null;
        if (entityResolver != null) {
            builder.setEntityResolver(entityResolver);
        }
        if (errorHandler != null) {
            builder.setErrorHandler(errorHandler);
        }

        //4.解析
        Document doc = builder.parse(inputSource);

        Element element = doc.getDocumentElement();





        //关闭流
        inputStream.close();

    }
}
