package by.it.savelyeva.jd_02_09.TaskC;

/**
 * Created by nato on 10/22/16.
 */
public class TaskC {
    public static void generateClassesFromXML() {
        String cmd = "/home/nato/Programs/jdk1.8.0_101/bin/xjc  /home/nato/java/idea/JD2016-08-29/src/by/it/savelyeva/jd_02_09/TaskC/RentCar.xsd -d /home/nato/java/idea/JD2016-08-29/src/";
        String output = "parsing a schema...\n" +
                "compiling a schema...\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Address.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Car.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/DriverLicence.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/ObjectFactory.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Orders.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Person.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Persons.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Photo.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Photos.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Rent.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/Rents.java\n" +
                "by/it/savelyeva/jd_02_09/task_c/xml/persons/package-info.java\n";

        System.out.printf("I ran command \n'%s'\n which produced the following output:\n\n%s", cmd, output);
    }

}
