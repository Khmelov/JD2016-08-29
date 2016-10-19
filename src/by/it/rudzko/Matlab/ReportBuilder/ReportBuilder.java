package by.it.rudzko.Matlab.ReportBuilder;


import java.io.File;

public abstract class ReportBuilder {
    Report report;

    Report getReport (){
        return report;
    }

    void createNewReport(){
        report=new Report();
    }

    abstract void printStart(File f);
    abstract void printOperations(File f);
    abstract void printEnd(File f);
}
