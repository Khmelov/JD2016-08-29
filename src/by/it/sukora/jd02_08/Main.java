package by.it.sukora.jd02_08;

/**
 * Created by Sukora Stas on 19.10.2016.
 */
public class Main {


    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        src = src.concat("/src/by/it/sukora/");
        String filename = src + "jd02_07/hospital.xml";
        String parsedSAX = TaskWithSAX.parseXML(filename);
        String parsedStAX = TaskWithStAX.parseXML(filename);
        String parsedDOM = TaskWithDOM.parseXML(filename);
        System.out.printf("ParsedDOM :\n%s\n\n", parsedDOM);
        System.out.println("All three results are equal to each other:");
        System.out.println("\tparsedSAX = parsedDOM: " + (parsedSAX.compareTo(parsedDOM) == 0));
        System.out.println("\tparsedStAX = parsedDOM: " + (parsedStAX.compareTo(parsedDOM) == 0));
    }
}
