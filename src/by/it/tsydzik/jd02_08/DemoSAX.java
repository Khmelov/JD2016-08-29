package by.it.tsydzik.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * @author Eugene Tsydzik
 * @since 19.10.2016.
 */
public class DemoSAX extends DefaultHandler {
    String text;
    String tab = "";

    public static void main(String[] args) {
        String fn = (System.getProperty("user.dir") + "/src/by/it/tsydzik/") + "jd02_08/ad.xml";
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DemoSAX sax = new DemoSAX();
            saxParser.parse(new File(fn), sax);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String attr = "";
        for (int i = 0; i < attributes.getLength(); i++) {
            attr = attr.concat(" " + attributes.getLocalName(i) + "=\"" + attributes.getValue(i) + "\"");
        }
        System.out.println(tab + "<" + qName + ">");
        text = "";
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!text.isEmpty()) {
            System.out.println(tab + text);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
        text = "";

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = text.concat((new String(ch, start, length)).trim());
    }
}
