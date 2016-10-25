package by.it.artiuschik.mathlab.logging;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeToLogfile(String errorMessage,String fileName)  {
        String path = System.getProperty("user.dir") +
                "/src/by/it/artiuschik/mathlab/logging/" + fileName;
        try (PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(path,true)))){
            Date d = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss",new Locale("be","BY"));
            //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale("be","BY"));
            String error = errorMessage +" "+ dateFormat.format(d);
            printer.println(error);
        }
        catch (IOException e) {
            this.writeToLogfile("Ошибка записи в logfile ",fileName);
        }
    }

}
