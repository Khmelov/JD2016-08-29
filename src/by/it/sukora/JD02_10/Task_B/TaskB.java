package by.it.sukora.JD02_10.Task_B;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by Sukora Stas.
 */
public class TaskB {

    public static void main(String[] args) {
        String strJSON;
        System.out.println("\nTask B: generate Java beans from XML; build new XML from classes");
        strJSON = TaskB.fromXML("Persons.xml");
        System.out.printf("JSON String:\n%s\n\n", strJSON);
        TaskB.toXML(strJSON, "Persons_generated.xml");
    }


    private static String src = System.getProperty("user.dir") + "/src/by/it/sukora/jd02_10/Task_B/";
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static String fromXML(String filename) {
        by.it.savelyeva.jd_02_10.TaskC.Converter.Persons persons = createPOJOfromXML(filename);
        String jsonStr = gson.toJson(persons);
        return jsonStr;
    }

    public static void toXML(String jsonStr, String filename) {
        by.it.savelyeva.jd_02_10.TaskC.Converter.Persons persons = gson.fromJson(jsonStr, by.it.savelyeva.jd_02_10.TaskC.Converter.Persons.class);
        System.out.print("\n\nPersons POJO = " + persons.toString());
        createXMLfromPOJO(persons, filename);
    }

    private static by.it.savelyeva.jd_02_10.TaskC.Converter.Persons createPOJOfromXML(String filename) {
        by.it.savelyeva.jd_02_10.TaskC.Converter.Persons persons = null;
        FileReader reader = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(by.it.savelyeva.jd_02_10.TaskC.Converter.Persons.class);
            Unmarshaller u = jc.createUnmarshaller();
            reader = new FileReader(src + filename);
            persons = (by.it.savelyeva.jd_02_10.TaskC.Converter.Persons) u.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private static void createXMLfromPOJO(by.it.savelyeva.jd_02_10.TaskC.Converter.Persons persons, String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(by.it.savelyeva.jd_02_10.TaskC.Converter.Persons.class);
            Marshaller m = context.createMarshaller();
            m.marshal(persons, new FileOutputStream(src + filename));
            //m.marshal(st, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-file cannot be created: " + e);
        } catch (JAXBException e) {
            System.out.println("Error in JAXB-context: " + e);
        }
    }
}
