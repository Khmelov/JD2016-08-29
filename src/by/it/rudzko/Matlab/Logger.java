package by.it.rudzko.Matlab;


import by.it.rudzko.Matlab.Interfaces.IMessages;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

class Logger {
    private static Logger ourInstance;
    private String error;


    public static Logger getInstance() {
        if (ourInstance==null)
            ourInstance = new Logger();

        return ourInstance;
    }

    private Logger() {

    }

    static void printError(String error){
        String src=System.getProperty("user.dir")+ IMessages.PATH;
        File f=new File(src+"Log.txt");
        PrintWriter n=null;
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
        String time = df.format(d);
        try{
            n=new PrintWriter(new FileWriter(f, true));
            n.println(time+": "+error);
            n.flush();
        }catch (FileNotFoundException e){
            System.out.println(IMessages.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }

        finally {
            if (n != null)
                n.close();
        }
    }
}
