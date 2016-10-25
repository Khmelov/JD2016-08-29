package by.it.akhmelev.jd02_09.demo.transformer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Run_XSL_transformer {
    final static String root="src/by/it/akhmelev/jd02_09/demo/transformer/";
    public static void main(String[ ] args) {
        String fileName=root+"ad.xml";
        String fileHTML=root+"ad.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"ad.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(System.out));

            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
}
}
