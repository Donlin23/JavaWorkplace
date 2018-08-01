package javaImooc.javaXML;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Author: Donlin
 * @Description: DOM的方式进行读取XML文件
 * @Date: Created in 17:14 2018/4/10
 * @Version: 1.0
 */
public class DOMTest {
    public static void main(String[] args) {
        //
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //
            DocumentBuilder db = dbf.newDocumentBuilder();
            //
            Document document = db.parse("F:\\JavaWorkplace\\XML\\books.xml");
            //
            NodeList booklist = document.getElementsByTagName("book");
            //
            for (int i = 0; i < booklist.getLength(); i++) {
                Node book = booklist.item(i);
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    System.out.println(attrs.item(j).getNodeName()+":"+attrs.item(j).getNodeValue());
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
