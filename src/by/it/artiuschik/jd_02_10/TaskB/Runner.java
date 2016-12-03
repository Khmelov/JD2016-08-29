package by.it.artiuschik.jd_02_10.TaskB;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

public class Runner {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        String path = src + "/src/by/it/artiuschik/jd_02_10/TaskB/";
        try {
            //From XML to JSON
            String json=FromXMLToJSON.fromPOJOToJSON(FromXMLToJSON.fromXMLToPOJO(path+"Students.xml"));
            //From JSON to XML
            FromJSONToXML.fromPOJOToXML(FromJSONToXML.fromJSONToPOJO(json),path+"StudentsNew.xml");

        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
