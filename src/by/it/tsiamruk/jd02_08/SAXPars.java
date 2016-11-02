package by.it.tsiamruk.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


/**
 * Created by waldemar on 25/10/2016.
 */
public class SAXPars extends DefaultHandler {
    private String tab = "";
    private String value;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("[startDocument]");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String atrName = attributes.getLocalName(i);
            String atrValue = attributes.getValue(i);
            System.out.printf(" %s =\"%s\"", atrName, atrValue);
        }
        System.out.println(">");
        tab += '\t';
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(tab + value);
        value = "";
        tab = tab.substring(1);
        System.out.printf("%s</%s>%n", tab, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("[endDocument]");
    }

    public static void saxParse(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXPars myImplementationSax = new SAXPars();
            parser.parse(new File(filePath), myImplementationSax);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
