package by.it.tsiamruk.matlab;

import by.it.tsiamruk.jd02_06.Logger;
import by.it.tsiamruk.matlab.vars.Var;

import java.util.Scanner;


public class Main {
    private static void printOneVar(Var v) {
        if (v != null) System.out.println(v);
    }
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        try {
            Scanner scanner = new Scanner(System.in);
            String line;
            Parser parser = new Parser();
            while ((line = scanner.nextLine()) != null) {
                if (line.toLowerCase().equals("exit"))
                    System.exit(0);
                Var var = parser.calculation(line);
                System.out.println(var);
            }
        } catch (Exception e) {
            String error = "Some error";
            logger.writeInLog(error, e);
            e.printStackTrace();
        }
    }
}

