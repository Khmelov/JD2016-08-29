package by.it.tsiamruk.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by waldemar on 28/10/2016.
 */
public class DOMPars {
    static void domParser(String filePath){
        System.out.println("DOM PARSER");
        //создание фабрики для создания объекта Дом Парсера
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //создание дом парсера
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //загружаем туда xml
            Document document = builder.parse(filePath);
            Element element = document.getDocumentElement();
                printDom(element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
    private static String getAttributes(Node node){
        String attributes = "";
        if (node.hasAttributes()){
            NamedNodeMap map = node.getAttributes();
            for (int i = 0; i < map.getLength(); i++) {
                attributes += " " + map.item(i).getNodeName() + "=" + map.item(i).getNodeValue();
            }
        }
        return attributes;
    }
    private static void printDom(Node node){
            switch (node.getNodeType()){
                case Node.ELEMENT_NODE:
                    System.out.print("<"+node.getNodeName() + getAttributes(node)+">");
                    break;
                case Node.TEXT_NODE:
                    System.out.print(node.getNodeValue());
                    break;
            }
            if (node.hasChildNodes()){
                NodeList childs = node.getChildNodes();
                for (int i = 0; i < childs.getLength(); i++) {
                    printDom(childs.item(i));
                }
                System.out.printf("</%s>", node.getNodeName());
            }

    }
}
