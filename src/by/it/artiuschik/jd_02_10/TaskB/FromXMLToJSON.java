package by.it.artiuschik.jd_02_10.TaskB;

import by.it.artiuschik.jd_02_09.TaskB_Manual.*;
import by.it.artiuschik.jd_02_10.TaskA.Cat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FromXMLToJSON {
    static Students fromXMLToPOJO(String XMLPath) throws JAXBException,FileNotFoundException
    {
            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/artiuschik/jd_02_09/TaskB_Manual/xml_01.xml");
            return (Students) u.unmarshal(reader);
    }
    public static String fromPOJOToJSON(Students students)
    {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(students);
        System.out.print(json);
        return json;
    }
}
