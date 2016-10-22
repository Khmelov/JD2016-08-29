package by.it.rudzko.XML.jd02_08_SAX_StAX_DOM;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserSAX extends DefaultHandler{

    private  String tab="";

    private StringBuilder text=new StringBuilder();

    private StringBuilder sb=new StringBuilder();

    public StringBuilder getSb() {
        return sb;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("SAX finished and wrote parsed data to txt file.");    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        sb.append(tab).append('<').append(qName);
        for (int i = 0; i <attr.getLength() ; i++) {
            sb.append(' ').append(attr.getLocalName(i)).append('=').append('\"').append(attr.getValue(i)).append('\"');
        }
        sb.append('>').append('\n');
        tab+='\t';
        text.delete(0,text.length());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (text.length()>0) sb.append(tab).append(text).append('\n');
        text.delete(0,text.length());   tab=tab.substring(1);
        sb.append(tab).append("</").append(qName).append('>').append('\n');
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch,start,length).trim());
    }
}
