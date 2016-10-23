package by.it.savelyeva.jd_02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by nato on 10/22/16.
 */
public class TaskA {
    final static String src = System.getProperty("user.dir") + "/src/by/it/savelyeva/jd_02_09/TaskA/";

    public static void transform(String fileXML, String fileXSL, String fileHTML) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(src + fileXSL));
            transformer.transform(new StreamSource(src + fileXML),
                    new StreamResult(src + fileHTML));
            //transformer.transform(new StreamSource(fileXML),
            //        new StreamResult(System.out));
            System.out.println("Done, please open RentCar.html in browser.");
        } catch(TransformerException e) {
            System.err.println("Impossible to transform the file: " + e.getMessage());
        }
    }

}
