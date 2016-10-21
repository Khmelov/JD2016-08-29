package by.it.rudzko.XML.SAX_StAX_DOM;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamConstants;

public class ParserStAX {
    private static StringBuilder sb=new StringBuilder();

    public static StringBuilder getSb() {
        return sb;
    }

    public static void parseStax(String fromFile){
        System.out.println("StAX parsing...");
        String tab="";
        try{
            XMLInputFactory inpF=XMLInputFactory.newInstance();
            XMLStreamReader read=inpF.createXMLStreamReader(new FileInputStream(fromFile));
            StringBuilder text=new StringBuilder();
            while (read.hasNext()){
                int type=read.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT: {
                        sb.append(tab).append('<').append(read.getLocalName());
                        tab+='\t';
                        int attr=read.getAttributeCount();
                        for (int i = 0; i < attr; i++) {
                            sb.append(" ").append(read.getAttributeLocalName(i)).append("=");
                            sb.append("\"").append(read.getAttributeValue(i)).append("\"");
                        }
                        sb.append('>').append('\n');
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        text.append(read.getText().trim()); break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        if (text.length()>0) sb.append(tab).append(text).append('\n');
                        tab=tab.substring(1); text.delete(0,text.length());
                        sb.append(tab).append("</").append(read.getLocalName()).append('>').append('\n');
                        break;
                    }

                }
            }
            System.out.println("StAX finished and wrote parsed data to txt file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (XMLStreamException e) {
            System.out.println("In-Out exception"+e.getMessage());
        }
    }
}
