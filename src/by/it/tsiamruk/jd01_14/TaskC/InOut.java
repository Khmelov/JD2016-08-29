package by.it.tsiamruk.jd01_14.TaskC;

import java.util.Scanner;

/**
 * Created by waldemar on 03/10/2016.
 */
public class InOut {
    //comment
    protected static String console() {
        System.out.println("Enter command");
        Scanner scan = new Scanner(System.in);
        String command = scan.next();
        return command;
    }
}
