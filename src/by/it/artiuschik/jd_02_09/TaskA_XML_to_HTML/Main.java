package by.it.artiuschik.jd_02_09.TaskA_XML_to_HTML;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        String pathXml = src + "/src/by/it/artiuschik/jd_02_09/TestingSystem.xml";
        String pathXsl = src + "/src/by/it/artiuschik/jd_02_09/TestingSystem.xsl";
        String pathHTML = src + "/src/by/it/artiuschik/jd_02_09/TestingSystem.html";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(pathXsl));
            transformer.transform(new StreamSource(pathXml),
                    new StreamResult(pathHTML));
            transformer.transform(new StreamSource(pathXml),
                    new StreamResult(System.out));

            System.out.println("Transform " + pathXml + " complete");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
