package by.it.savelyeva.jd_02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by nato on 10/22/16.
 */
public class TaskB {

    private static String src = System.getProperty("user.dir") + "/src/by/it/savelyeva/jd_02_09/TaskB/";

    public static String fromXML(String filename) {
        String res = "";
        FileReader reader = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(by.it.savelyeva.jd_02_09.TaskB.Persons.class);
            Unmarshaller u = jc.createUnmarshaller();
            reader = new FileReader(src + filename);
            Persons persons = (Persons) u.unmarshal(reader);
            res = persons.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void toXML(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller m = context.createMarshaller();
            Persons st = new Persons() { // anonymous class
                {
                    Person person;
                    Person.Address addr;
                    Person.DriverLicence dl;
                    addr = new Person.Address("Belarus", "Minsk", "Lenina", "3", "21");
                    dl = new Person.DriverLicence("AB1252215", "B", "2010-12-20", "2020-12-20");
                    person = new Person("Alexander", "Ivanov", "M", "1979-09-12", "BM1932121",
                            "ivan1979", "password1", "+375294586954", addr, dl);
                    this.add(person);

                    addr = new Person.Address("Belarus", "Gomel", "Sovetskaya", "7", "14");
                    dl = new Person.DriverLicence("AB3462270", "B", "2016-10-10", "22026-10-09");
                    person = new Person("Alina", "Petrova", "F", "1991-09-12", "BM2342122",
                                        "ale4ka", "password", "+375444586953", addr, dl);
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
