package by.it.artiuschik.jd_02_08;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX extends DefaultHandler{
    public static void main(String[] args) {
        try {
            String src = System.getProperty("user.dir");
            String path = src + "/src/by/it/artiuschik/jd_02_07/TestingSystem+XSD.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX myImplementationSax = new SAX();
            parser.parse(new File(path), myImplementationSax);
        } catch (IOException e) {
            System.out.println("Failed or interrupted I/O operation!");
        } catch (SAXException e) {
            System.out.println("General SAX error!");
        } catch (ParserConfigurationException e) {
            System.out.println("Error in parser configuration!");
        }
    }
    private String tab = "";//отступы
    private String value;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document parsing.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\"" + value+"\"");
        }
        System.out.println(">");
        tab = '\t' + tab; //добавим табулятор
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(tab + value);
        value = "";
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }
}