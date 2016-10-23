package by.it.emelyanov.jd02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL_Transformer {
    final static String path="src/by/it/emelyanov/jd02_09/files/";

    public static void main(String[] args) {
        String fileXML = path + "Hotel.xml";
        String fileHTML = path +"Hotel.html";
        String fileXSL = path + "Hotel.xsl";
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(fileXSL));
            transformer.transform(new StreamSource(fileXML), new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileXML), new StreamResult(System.out));
            System.out.println("Transform"+fileXML+"complited");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
