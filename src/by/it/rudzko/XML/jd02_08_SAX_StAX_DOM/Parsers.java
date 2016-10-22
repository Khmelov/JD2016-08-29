package by.it.rudzko.XML.jd02_08_SAX_StAX_DOM;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Parsers {
    public static void main(String[] args) {
        PrintWriter n=null;
        String fromFile="src/by/it/rudzko/XML/jd02_08_SAX_StAX_DOM/plain.xml";
        try {
        //parsing by SAX
            SAXParserFactory create = SAXParserFactory.newInstance();
            SAXParser parser = create.newSAXParser();
            ParserSAX sax = new ParserSAX();
            parser.parse(fromFile, sax);
            File f=new File(System.getProperty("user.dir")+"/src/by/it/rudzko/XML/jd02_08_SAX_StAX_DOM/res_SAX.txt");
            n=new PrintWriter(new FileWriter(f, true));
            n.println(sax.getSb());
            n.flush();
        //parsing by StAX
            ParserStAX.parseStax(fromFile);
            File f2=new File(System.getProperty("user.dir")+"/src/by/it/rudzko/XML/jd02_08_SAX_StAX_DOM/res_StAX.txt");
            n=new PrintWriter(new FileWriter(f2, true));
            n.println(ParserStAX.getSb());
            n.flush();
        //parsing by DOM
            DocumentBuilder b=DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Element elem=b.parse(fromFile).getDocumentElement();
            System.out.println("DOM parsing...");
            ParserDOM.parseDom("", elem);
            File f3=new File(System.getProperty("user.dir")+"/src/by/it/rudzko/XML/jd02_08_SAX_StAX_DOM/res_DOM.txt");
            n=new PrintWriter(new FileWriter(f3, true));
            n.println(ParserDOM.getSb());
            n.flush();

            System.out.println("Results of parsing are in text documents.");
        } catch (SAXException e) {
            System.out.println("Error of parsing.\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("In-Out exception.\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Wrong configuration.\n" + e.getMessage());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (n != null)
                n.close();
        }
    }
}
