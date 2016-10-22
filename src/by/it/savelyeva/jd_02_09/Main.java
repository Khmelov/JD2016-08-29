package by.it.savelyeva.jd_02_09;

import by.it.savelyeva.jd_02_09.TaskA.TaskA;
import by.it.savelyeva.jd_02_09.TaskB.TaskB;
import by.it.savelyeva.jd_02_09.TaskC.TaskC;

/**
 * Created by nato on 10/22/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\nTask A: Do transformation XML->HTML using XSL:");
        TaskA.transform("RentCar.xml", "RentCar.xsl", "RentCar.html");

        System.out.println("\nTask B: generate Java beans from XML; build new XML from classes");
        TaskB.toXML("Persons_generated.xml");
        String res = TaskB.fromXML("Persons.xml"); // unmarshall
        System.out.println("\tDescription of objects generated from XML:\n" + res);

        System.out.println("\nTask C: Based on XSD-file, generate Java classes using xjc tool:");
        TaskC.generateClassesFromXML();
    }
}

