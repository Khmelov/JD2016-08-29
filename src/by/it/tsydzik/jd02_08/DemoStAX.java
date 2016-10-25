package by.it.tsydzik.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * @author Eugene Tsydzik
 * @since 19.10.2016.
 */
public class DemoStAX {
    public static void main(String[] args) {
        String fn = (System.getProperty("user.dir") + "/src/by/it/tsydzik/") + "jd02_08/ad.xml";
        String tab = "";
        String text = "";
        String tag = "";

        try {
            FileInputStream fr = new FileInputStream(fn);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fr);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tag = reader.getLocalName();
                        String attr = "";
                        int attrCount = reader.getAttributeCount();
                        for (int i = 0; i < attrCount; i++) {
                            String name = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            attr = attr + " " + name + "=" + value;
                        }
                        System.out.println(tab + "<" + tag + attr + ">");
                        tab = tab + "\t";
                        break;
                }
                switch (type) {
                    case XMLStreamConstants.END_ELEMENT:
                        if (!text.isEmpty()) {
                            System.out.println(tab + text);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + tag + ">");
                        text = "";
                        break;
                }
                switch (type) {
                    case XMLStreamConstants.CHARACTERS:
                        text = text.concat(reader.getText().trim());
                        break;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
