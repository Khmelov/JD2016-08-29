package by.it.laurynovich.jd02_06;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SingletonLogger {
    private static SingletonLogger instance;
    private String filename;

    private SingletonLogger() {
        String src = System.getProperty("user.dir");
        src = src.concat("/src/by/it/laurynovich/");
        filename = src + "jd02_06/log.txt";
    };

    public static SingletonLogger getInstance() {
        SingletonLogger localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonLogger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonLogger();
                }
            }
        }
        return localInstance;
    }

    public void log(String msg) {
        Date d = new Date();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
            out.printf("%s: %s\n", d.toString(), msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}