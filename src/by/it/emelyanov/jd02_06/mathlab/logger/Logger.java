package by.it.emelyanov.jd02_06.mathlab.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static Logger myLogger;
    private static final String file = "src/by/it/emelyanov/jd02_06/mathlab/logs/log.txt";

    private Logger() {

    }

    public static Logger getMyLoger() {
        if (myLogger == null) {
            myLogger = new Logger();
        }
        return myLogger;
    }


    public void writeInLog(String error) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        File log = new File(file);

        try (FileWriter fileWriter = new FileWriter(log, true)) {
            String logException = error + " "  + " " + dateFormat.format(date) + "\n";
            fileWriter.append(logException);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
