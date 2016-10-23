package by.it.emelyanov.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    public static void main(String[] args) {
        String filename = "src/by/it/emelyanov/jd02_08/Hotel+XSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(filename);
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            printElement(root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printElement(Node node) {
        short type = node.getNodeType();
        if (type == Node.ELEMENT_NODE) {
            System.out.print("<" + node.getNodeName());
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                printElement(attributes.item(i));
            }
            System.out.print(">");
            if (node.hasChildNodes()) {
                NodeList childNodes = node.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    printElement(childNodes.item(i));
                }
                System.out.print("</" + node.getNodeName() + ">");
            }
        } else if (type == Node.ATTRIBUTE_NODE) {
            System.out.print(" " + node.getNodeName() + "=\"");
            System.out.print(((Attr) node).getValue() + "\"");
        } else if (type == Node.TEXT_NODE) {
            System.out.print(node.getNodeValue());
        }
    }
}

