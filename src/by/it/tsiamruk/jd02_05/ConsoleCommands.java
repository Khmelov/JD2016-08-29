package by.it.tsiamruk.jd02_05;

import java.util.Scanner;

/**
 * Created by waldemar on 12/10/2016.
 */
public class ConsoleCommands {
    static String command() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        return command;
    }
}
