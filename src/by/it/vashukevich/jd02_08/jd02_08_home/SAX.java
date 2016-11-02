package by.it.vashukevich.jd02_08.jd02_08_home;

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
        String file="D:\\Java\\JD2016-08-29\\src\\by\\it\\vashukevich\\jd02_08\\jd02_08_home\\elective.xml";
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser=saxParserFactory.newSAXParser();
            SAX sax=new SAX();
            saxParser.parse(new File(file),sax);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки");
    }
    String tab="";
    String text;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String at="";
        for (int i = 0; i <attributes.getLength() ; i++) {
            at=at.concat(" "+attributes.getLocalName(i)+"=\""+attributes.getValue(i)+"\"");
        }
        System.out.println(tab+"<"+qName+at+">");
        text="";
        tab=tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!text.isEmpty())
           System.out.println(tab+text);
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
        text="";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text=text.concat((new String(ch,start,length)).trim());
    }
}
