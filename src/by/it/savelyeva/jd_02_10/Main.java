package by.it.savelyeva.jd_02_10;

import by.it.savelyeva.jd_02_10.TaskA.TaskA;
import by.it.savelyeva.jd_02_10.TaskB.TaskB;
import by.it.savelyeva.jd_02_10.TaskC.Converter.Persons;
import by.it.savelyeva.jd_02_10.TaskC.Converter.TaskC;

/**
 * Created by nato on 10/22/16.
 */
public class Main {
    public static void main(String[] args) {
        String strJSON;
        String strXML;
        System.out.println("\nTask A: perform marshalling and unmarshalling (POJO <- -> JSON String)");
        strJSON = TaskA.marshalling();
        System.out.printf("JSON String:\n%s\n\n", strJSON);
        TaskA.unmarshalling(strJSON);


        System.out.println("\nTask B: generate Java beans from XML; build new XML from classes");
        strJSON = TaskB.fromXML("Persons.xml");
        System.out.printf("JSON String:\n%s\n\n", strJSON);
        TaskB.toXML(strJSON, "Persons_generated.xml");


        System.out.println("\nTask C: create universal converter xml <- -> json");

        Class beanClass = Persons.class;

        strJSON = TaskC.fromFileXMLtoStringJSON("Persons.xml", beanClass);
        System.out.printf("JSON String from Persons.xml:\n%s\n", strJSON);

        TaskC.fromFileXMLtoFileJSON("Persons.xml", "Persons.json", beanClass);
        System.out.println("Persons.xml was converted to Persons.json, please check this file.");

        strXML = TaskC.fromFileJSONtoStringXML("Persons.json", beanClass);
        System.out.printf("XML String from Persons.json:\n%s\n", strXML);

        TaskC.fromStringJSONtoStringXML(strJSON, beanClass);
        System.out.printf("XML String from JSON String:\n%s\n", strXML);
    }
}
