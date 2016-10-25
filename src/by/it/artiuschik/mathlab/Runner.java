package by.it.artiuschik.mathlab;
import by.it.artiuschik.mathlab.logging.Logger;
import by.it.artiuschik.mathlab.report.*;
import by.it.artiuschik.mathlab.report.ShortReportBuilder;
import by.it.artiuschik.mathlab.utils.*;
import by.it.artiuschik.mathlab.vars.Var;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    public static Logger logger=Logger.getInstance();
    public static HashMap<String,String> operResults=new HashMap<>();
    public static Date start=null;
    public static Date end=null;
    public static void main(String[] args) {
        start=new Date();
        try {
            VarsReader.readFromFile("vars.txt");//значения переменных в  hashmap
            Parser parser = new Parser();
            System.out.println("Введите выражение или end");
                Scanner sc = new Scanner(System.in);
                String str;
            while ((str=sc.nextLine())!=null) {
                if (str.toLowerCase().equals("end")) {
                    end=new Date();
                    ReportBuilder rb;
                    Director dir = new Director();
                    rb = new FullReportBuilder();
                    dir.setReportBuilder(rb);
                    dir.constructReport("full_report.txt");
                    rb = new ShortReportBuilder();
                    dir.setReportBuilder(rb);
                    dir.constructReport("short_report.txt");
                    logger.writeToLogfile("end", "log.txt");
                   System.exit(0);
                } else {
                    Var var = parser.calc(str);
                    System.out.println(var);
                    operResults.put(str,var.toString());
                }

            }
        }
        catch(IOException e)
        {
            System.out.println("Exception from file");
        }
        catch(Exception e)
        {
            logger.writeToLogfile("Exception from Parser","log.txt");
        }


    }
}
