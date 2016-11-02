package by.it.tsiamruk.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by waldemar on 25/10/2016.
 */
public class Logger {
    private static Logger instance = null;
    private String path = System.getProperty("user.dir").concat("/src/by/it/tsiamruk/");
    private final String filePath = path + "jd02_06/log.txt";

    protected Logger() {
        //empty constructor
    }

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void writeInLog(String err, Exception e) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        File log = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(log, true)) {
            String logMessage = "Exception message " + err + " " + e + " " + "Date: " + dateFormat.format(date) + "\n";
            fileWriter.append(logMessage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
