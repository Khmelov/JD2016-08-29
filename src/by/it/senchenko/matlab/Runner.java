package by.it.senchenko.matlab;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        while ((line = scanner.nextLine()) != null) {
            if (line.toLowerCase().equals("exit"))
                System.exit(0);
            Var var = parser.calc(line);
            System.out.println(var);
        }
    }
}
