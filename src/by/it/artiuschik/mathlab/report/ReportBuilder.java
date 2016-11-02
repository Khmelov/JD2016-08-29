package by.it.artiuschik.mathlab.report;

public abstract class ReportBuilder {
    Report report=new Report();
    Report getReport(){
        return report;
    }
    void createNewReport(){report=new Report();}
    public  void setReportFileName(String fileName){
        report.setPathToFile(fileName);
    }
    public abstract void createReportName();
    public abstract void setReportStart();
    public abstract void setReportEnd();
    public abstract void setReportOperations();
    public abstract void writeReport();

}
