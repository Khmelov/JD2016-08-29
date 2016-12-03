package by.it.artiuschik.mathlab.report;

public class Director {
    private ReportBuilder reportBuilder;
    public void setReportBuilder(ReportBuilder reportBuilder)
    {
        this.reportBuilder=reportBuilder;
    }
    public void constructReport(String fileName)
    {
        reportBuilder.setReportFileName(fileName);
        reportBuilder.createReportName();
        reportBuilder.setReportStart();
        reportBuilder.setReportEnd();
        reportBuilder.setReportOperations();
        reportBuilder.writeReport();
    }
}
