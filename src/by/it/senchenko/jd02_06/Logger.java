package by.it.senchenko.jd02_06;


import java.io.*;
import java.util.Date;

public class Logger {
    private static Logger instance;
    static String path = "D:\\JD2016-08-29\\src\\by\\it\\senchenko\\jd02_06\\log.txt";

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void errToLog(String err) {
        Date date = new Date();
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
            System.out.printf("Error time %s: %s\n", date, err);
            printWriter.printf("Error time %s: %s\n", date, err);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}