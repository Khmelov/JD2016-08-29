package by.it.sukora.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Sukora Stas on 19.10.2016.
 */

public class TaskWithDOM {
    private static StringBuilder sb = new StringBuilder();
    private static String tab = "";

    public static String parseXML(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filename);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Error! " + e.toString());
        }
        return sb.substring(1).replaceAll("\n\t", "\n");
    }

    private static String getAttrsStr(Node node) {
        String attrs = "";
        if (node.hasAttributes()) {
            NamedNodeMap attribs = node.getAttributes();
            for (int i=0; i<attribs.getLength(); i++) {
                attrs += " " + attribs.item(i).getNodeName() + "=\"" + attribs.item(i).getNodeValue() + "\"";
            }
        }
        return attrs;
    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        String attrs = "";
        if (text != null) {
            text = text.trim();
            if (!node.hasChildNodes()) {
                attrs = getAttrsStr(node.getParentNode());
                String tag = node.getParentNode().getNodeName();
                if (node.getParentNode().getFirstChild().isSameNode(node)) {
                    sb.append(tab).append("<").append(tag).append(attrs).append(">").append("\n");
                }
                if (text.compareTo("") != 0)
                    sb.append(tab).append("\t").append(text).append("\n");
                if (node.getParentNode().getLastChild().isSameNode(node)) {
                    sb.append(tab).append("</").append(tag).append(">").append("\n");
                }
            }
        } else if (!node.hasChildNodes()) {
            attrs = getAttrsStr(node);
            sb.append(tab).append("\t").append("<").append(node.getNodeName()).append(attrs).append(" />").append("\n");
        }
        NodeList children = node.getChildNodes();
        tab += "\t";
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + node.getNodeName() + ">", children.item(i));
        }
        tab = tab.substring(1);
    }
}
