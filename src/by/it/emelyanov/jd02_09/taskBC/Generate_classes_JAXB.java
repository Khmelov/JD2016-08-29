package by.it.emelyanov.jd02_09.taskBC;

import by.it.emelyanov.jd02_09.classes.Hotels;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Generate_classes_JAXB {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotels.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/emelyanov/jd02_09/files/Hotel+XSD.xml");
            System.out.println("XML файл прочитан: ");
            Hotels hotel =(Hotels)unmarshaller.unmarshal(reader);
            System.out.println(hotel);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
