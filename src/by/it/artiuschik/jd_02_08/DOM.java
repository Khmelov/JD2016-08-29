package by.it.artiuschik.jd_02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {
    public static void main(String[] args) {
        String tab = "";
        String src = System.getProperty("user.dir");
        String path = src + "/src/by/it/artiuschik/jd_02_07/TestingSystem+XSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            Element el = doc.getDocumentElement();
            printDom(tab, el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    private static void printDom(String str, Node node) {
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(str + text.trim());
        }
        NodeList children = node.getChildNodes();
        if (children.getLength() > 0) {
            System.out.print(str + "<" + node.getNodeName() + " ");
            str += "\t";
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                System.out.print(" " + node.getAttributes().item(i));
            }
            System.out.println(">");
        }
        for (int i = 0; i < children.getLength(); i++) {
            printDom(str, children.item(i));
        }
        if (children.getLength() > 0) {
            System.out.print(str + "</" + node.getNodeName() + ">");
        }
    }
}
