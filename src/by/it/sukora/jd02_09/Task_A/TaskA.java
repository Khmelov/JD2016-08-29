package by.it.sukora.jd02_09.Task_A;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Sukora Stas.
 */
public class TaskA {
    public static void main(String[] args) {
        try {
            String path = "src/by/it/sukora/jd02_09/Task_A/";
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource source = new StreamSource(path + "hospital.xsl");
            Transformer t = factory.newTransformer(source);
            t.transform(new StreamSource(path + "hospital.xml"), new StreamResult(path + "hospital.html"));
            System.out.println("HTML создан");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
