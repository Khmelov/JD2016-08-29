package by.it.sukora.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by Sukora Stas on 19.10.2016.
 */
public class TaskWithSAX extends DefaultHandler {

    private String tab = "";
    private String value;
    private static StringBuilder sb = new StringBuilder();

    public static String parseXML(String filename) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            TaskWithSAX myImplementationSax = new TaskWithSAX();
            parser.parse(new File(filename), myImplementationSax);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString().replaceAll(" >\n[\t]+</[a-zA-Z]+>", " />").replaceAll(" >", ">");
    }

    @Override
    public void startDocument() throws SAXException {
        //sb.append("\n\t\tParsing started\n\n");
    }

    @Override
    public void endDocument() throws SAXException {
        //sb.append("\n\t\tParsing completed\n\n");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.append(tab).append("<").append(qName);
        for (int i=0; i<attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            sb.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        if (attributes.getLength() > 0) sb.append(" ");
        sb.append(">\n");
        tab += "\t";
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty()) {
            sb.append(tab).append(value).append("\n");
        }
        tab = tab.substring(1);
        sb.append(tab).append("</").append(qName).append(">\n");
        value = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }

}
