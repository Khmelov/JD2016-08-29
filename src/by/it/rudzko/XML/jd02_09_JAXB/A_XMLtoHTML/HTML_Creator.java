package by.it.rudzko.XML.jd02_09_JAXB.A_XMLtoHTML;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTML_Creator {
    public static void main(String[] args) {
        try {
            String path = "src/by/it/rudzko/XML/jd02_09_JAXB/A_XMLtoHTML/";
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource source = new StreamSource(path + "translator.xsl");
            Transformer t = factory.newTransformer(source);
            t.transform(new StreamSource(path + "plain.xml"), new StreamResult(path + "periodicals.html"));
            System.out.println("HTML created.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
