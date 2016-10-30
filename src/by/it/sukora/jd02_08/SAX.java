package by.it.sukora.jd02_08;

/**
 * Created by Sukora Stas on 19.10.2016.
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import by.it.sukora.jd02_07.*;

public class SAX extends DefaultHandler {
    public static void main(String[] args) {
        String fn="D:\\курсы JAVA\\занятия\\JD2016-08-29\\src\\by\\it\\sukora\\jd02_07\\hospital.xml";
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX sax = new SAX();
            saxParser.parse(new File("D:\\курсы JAVA\\занятия\\JD2016-08-29\\src\\by\\it\\sukora\\jd02_07\\hospital.xml"),sax);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String txt;
    String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       String attr="";
        for (int i = 0; i < attributes.getLength(); i++) {
            attr=attr.concat(" "+attributes.getLocalName(i)+"=\""+attributes.getValue(i)+"\"");
        }


        System.out.println("<" + qName + ">");
        txt = "";
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!txt.isEmpty())
            System.out.println(tab + txt);
        tab = tab.substring(1);
        System.out.println(tab + "<" + qName + ">");
        txt="";

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        txt=txt.concat((new String(ch,start,length)).trim());
    }
}
