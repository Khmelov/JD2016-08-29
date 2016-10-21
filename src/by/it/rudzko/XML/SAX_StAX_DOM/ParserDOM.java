package by.it.rudzko.XML.SAX_StAX_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserDOM {
    private static StringBuilder sb=new StringBuilder();

    public static StringBuilder getSb() {
        System.out.println("DOM finished and wrote data to tst file.");
        return sb;
    }

    public static void parseDom(String pref, Node node) {

        String text=node.getNodeValue();
        if (text!=null){
            sb.append(pref).append(text.trim()).append('\n');
        }
        NodeList children=node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            parseDom(pref+node.getNodeName()+'>', children.item(i));
        }

    }
}
