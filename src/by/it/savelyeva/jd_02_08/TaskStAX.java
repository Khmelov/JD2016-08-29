package by.it.savelyeva.jd_02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Created by nato on 10/19/16.
 */
public class TaskStAX {

    private static String tab = "";
    private static StringBuilder sb = new StringBuilder();

    public static String parseXML(String filename) {
        try {
            FileInputStream input = new FileInputStream(filename);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(input);
            String elem = "";
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        sb.append(tab).append("<").append(reader.getLocalName());
                        String attrs = "";
                        for (int i=0; i<reader.getAttributeCount(); i++) {
                            attrs += " " + reader.getAttributeLocalName(i) + "=\"" + reader.getAttributeValue(i) + "\"";
                        }
                        sb.append(attrs).append(" >\n");
                        tab += "\t";
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        elem = elem.concat(reader.getText().trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (!elem.isEmpty()) {
                            sb.append(tab).append(elem).append("\n");
                        }
                        tab = tab.substring(1);
                        elem = "";
                        sb.append(tab).append("</").append(reader.getLocalName()).append(">\n");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString().replaceAll(" >\n[\t]+</[a-zA-Z]+>", " />").replaceAll(" >", ">");
    }
}
