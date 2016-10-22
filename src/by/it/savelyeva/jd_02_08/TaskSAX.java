package by.it.savelyeva.jd_02_08;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by nato on 10/19/16.
 */
public class TaskSAX extends DefaultHandler {

    private String tab = "";
    private String value;
    private static StringBuilder sb = new StringBuilder();

    public static String parseXML(String filename) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            TaskSAX myImplementationSax = new TaskSAX();
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
