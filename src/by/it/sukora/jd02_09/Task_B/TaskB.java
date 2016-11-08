package by.it.sukora.jd02_09.Task_B;


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
        TaskB.toXML("hospital_generate.xml");
        String res = TaskB.fromXML("hospital.xml"); // unmarshall
        System.out.println("\tDescription of objects generated from XML:\n" + res);
    }


    private static String src = System.getProperty("user.dir") + "/src/by/it/sukora/jd02_09/Task_B/";

    public static String fromXML(String filename) {
        String res = "";
        FileReader reader = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(by.it.sukora.jd02_09.Task_B.Hospital_2.class);
            Unmarshaller u = jc.createUnmarshaller();
            reader = new FileReader(src + filename);
            Hospital hospital = (Hospital) u.unmarshal(reader);
            res = hospital.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void toXML(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(Hospital_2.class);
            Marshaller m = context.createMarshaller();
            Hospital_2 st = new Hospital_2() { // anonymous class
                {
                    Hospital person;
                    Hospital.Address addr;
                    Hospital.MedicalCard dl;
                    addr = new Hospital.Address("Belarus", "Minsk", "Lenina", "3", "21");
                    dl = new Hospital.MedicalCard("AB1252215", "", "", "", "");
                    person = new Hospital("Alexander", "Ivanov", "M", "1979-09-12", "BM1932121",
                            "ivan1979", "password1", "+375294586954", addr);
                    this.add(person);

                    addr = new Hospital.Address("Belarus", "Gomel", "Sovetskaya", "7", "14");
                   // dl = new Hospital.MedicalCard("AB3462270", "B", "2016-10-10", "22026-10-09");
                    person = new Hospital("Alina", "Petrova", "F", "1991-09-12", "BM2342122",
                            "ale4ka", "password", "+375444586953", addr);
                    this.add(person);
                }
            };
            m.marshal(st, new FileOutputStream(src + filename));
            //m.marshal(st, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-file cannot be created: " + e);
        } catch (JAXBException e) {
            System.out.println("Error in JAXB-context: " + e);
        }
    }
}
