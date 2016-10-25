package by.it.savelyeva.jd_02_08;

/**
 * Created by nato on 10/19/16.
 */
public class Main {


    public static void main(String[] args) {
        String src = System.getProperty("user.dir"); // get project path
        src = src.concat("/src/by/it/savelyeva/");   // get dir
        String filename = src + "jd_02_08/RentCar.xml";     // get absolute file path

        String parsedSAX = TaskSAX.parseXML(filename);
        //System.out.println(parsedSAX);

        String parsedStAX = TaskStAX.parseXML(filename);
        //System.out.println(parsedStAX);

        String parsedDOM = TaskDOM.parseXML(filename);
        //System.out.println(parsedDOM);

        System.out.printf("ParsedDOM :\n%s\n\n", parsedDOM);
        System.out.println("All three results are equal to each other:");
        System.out.println("\tparsedSAX = parsedDOM: " + (parsedSAX.compareTo(parsedDOM) == 0));
        System.out.println("\tparsedStAX = parsedDOM: " + (parsedStAX.compareTo(parsedDOM) == 0));
    }
}
