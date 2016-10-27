package by.it.tsiamruk.jd02_08;




import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by waldemar on 25/10/2016.
 */
public class StAXPars {
    private static String tab = "";

    public static void staxParce(String filePath) {
        try {

            FileInputStream inputStream = new FileInputStream(filePath);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);

            String el = "";

            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.printf("%s<%s", tab, reader.getLocalName());
                        tab += "\t";
                        int countAttr = reader.getAttributeCount();
                        for (int i = 0; i < countAttr; i++) {
                            System.out.printf(" %s=", reader.getAttributeLocalName(i));
                            System.out.printf("\"%s\"", reader.getAttributeValue(i));
                        }
                        System.out.println(">");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        el = el.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!el.isEmpty())
                            System.out.println(tab + el);
                        tab = tab.substring(1);
                        el = "";
                        System.out.printf("%s</%s>%n", tab, reader.getLocalName());
                        break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
