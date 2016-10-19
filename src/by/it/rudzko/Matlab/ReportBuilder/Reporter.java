package by.it.rudzko.Matlab.ReportBuilder;


import by.it.rudzko.Matlab.Interfaces.IMessages;

import java.io.File;

public class Reporter {

    File file=new File(System.getProperty("user.dir")+ IMessages.PATH+"Report.txt");

    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb){
        reportBuilder=rb;
    }

    Report getReport (){
        return reportBuilder.getReport();
    }

    public void constructReport(){
        reportBuilder.createNewReport();
        reportBuilder.printStart(file);
        reportBuilder.printOperations(file);
        reportBuilder.printEnd(file);
    }

}
