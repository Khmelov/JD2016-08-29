package by.it.akhmelev.jd02_09.demo.xcj;
//тут нужно указать путь к сгенерированным классам

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Run_JaxB_use_xjc {
        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Persons.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/akhmelev/jd02_09/demo/xcj/ad-xsd.xml");
                System.out.println("XML-файл прочитан:");
                Persons persons = (Persons) u.unmarshal(reader);
                System.out.println(persons);

            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }