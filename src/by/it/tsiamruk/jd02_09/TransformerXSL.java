package by.it.tsiamruk.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by waldemar on 29/10/2016.
 */
public class TransformerXSL {
    private final static String root ="src/by/it/tsiamruk/jd02_07/";
    public static void main(String[] args) {
        String fileName = root + "paymentSystem.xml";
        String fileHTML = root + "paymentSystem.html";
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(root+
            "paymentSystem.xsl"));
//            transformer.transform(new StreamSource(fileName), new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileName), new StreamResult(System.out));
            System.out.printf("Transform %s complete%n", fileName);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
